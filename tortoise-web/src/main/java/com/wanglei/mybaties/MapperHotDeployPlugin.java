package com.wanglei.mybaties;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
@Component
public class MapperHotDeployPlugin implements InitializingBean, ApplicationContextAware {
    private final static String OPEN = "1";
    private volatile SqlSessionFactoryBean sqlSessionFactoryBean;
    private volatile Configuration configuration;

    @Override
    public void afterPropertiesSet() {
        String flag = "1";
        System.out.println("Mybatis热部署标识mapper.hot");
        if (OPEN.equals(flag)) {
            new WatchThread().start();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Mybatis热部署标识");

        sqlSessionFactoryBean = (SqlSessionFactoryBean) applicationContext.getBean("&sqlSessionFactory");
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
        }

        configuration = sqlSessionFactory.getConfiguration();
    }

    class WatchThread extends Thread {

        @Override
        public void run() {
            startWatch();
        }

        /**
         * 启动监听
         *
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private void startWatch() {
            try {
                System.out.println("启动了xml文件热部署");
                WatchService watcher = FileSystems.getDefault().newWatchService();
                getWatchPaths().forEach(p -> {
                    try {
                            Paths.get(p).register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
                    } catch (Exception e) {
                        throw new RuntimeException("ERROR: 注册xml监听事件", e);
                    }
                });
                while (true) {
                    WatchKey watchKey = watcher.poll();
                    if(watchKey!=null){
                        System.out.println("监听到了");
                        Set<String> set = new HashSet<>();
                        for (WatchEvent<?> event : watchKey.pollEvents()) {
                            set.add(event.context().toString());
                        }
                        System.out.println(set.toString());
                        // 重新加载xml
                        reloadXml(set);
                        boolean valid = watchKey.reset();
                        if (!valid) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Mybatis的xml监控失败!");
            }
        }

        /**
         * 加载需要监控的文件父路径
         *
         * @return java.util.Set<java.lang.String>
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private Set<String> getWatchPaths() {
            Set<String> set = new HashSet<>();
            Arrays.stream(getResource()).forEach(r -> {
                try {
                    set.add(r.getFile().getParentFile().getAbsolutePath());
                } catch (Exception e) {
                    throw new RuntimeException("获取资源路径失败");
                }
            });
            return set;
        }

        /**
         * 获取配置的mapperLocations
         *
         * @return org.springframework.core.io.Resource[]
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private Resource[] getResource() {
            return (Resource[]) getFieldValue(sqlSessionFactoryBean, "mapperLocations");
        }

        /**
         * 删除xml元素的节点缓存
         *
         * @param nameSpace xml中命名空间
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private void clearMap(String nameSpace) {
            Arrays.asList("mappedStatements", "caches", "resultMaps", "parameterMaps", "keyGenerators", "sqlFragments").forEach(fieldName -> {
                Object value = getFieldValue(configuration, fieldName);
                if (value instanceof Map) {
                    Map<?, ?> map = (Map) value;
                    List<Object> list = map.keySet().stream().filter(o -> o.toString().startsWith(nameSpace + ".")).collect(Collectors.toList());
                    list.forEach(k -> map.remove((Object) k));
                }
            });
        }

        /**
         * 清除文件记录缓存
         *
         * @param resource xml文件路径
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private void clearSet(String resource) {
            Object value = getFieldValue(configuration, "loadedResources");
            if (value instanceof Set) {
                Set<?> set = (Set) value;
                set.remove(resource);
                set.remove("namespace:" + resource);
            }
        }

        /**
         * 获取对象指定属性
         *
         * @param obj       对象信息
         * @param fieldName 属性名称
         * @return java.lang.Object
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private Object getFieldValue(Object obj, String fieldName) {
            try {
                Field field = obj.getClass().getDeclaredField(fieldName);
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                Object value = field.get(obj);
                field.setAccessible(accessible);
                return value;
            } catch (Exception e) {
                throw new RuntimeException("ERROR: 加载对象中[" + fieldName + "]", e);
            }
        }

        /**
         * 重新加载set中xml
         *
         * @param set 修改的xml资源
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private void reloadXml(Set<String> set) {
            System.out.println("开始重新加载xml文件");
            List<Resource> list = Arrays.stream(getResource())
                    .filter(p -> set.contains(p.getFilename()))
                    .collect(Collectors.toList());
            list.forEach(r -> {
                try {
                    clearMap(getNamespace(r));
                    clearSet(r.toString());
                    XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(r.getInputStream(), configuration,
                            r.toString(), configuration.getSqlFragments());
                    xmlMapperBuilder.parse();
                    System.out.println("加载xml文件结束成功热部署");
                } catch (Exception e) {
                    throw new RuntimeException("ERROR: 重新加载[" + r.toString() + "]失败", e);
                } finally {
                    ErrorContext.instance().reset();
                }
            });
        }

        /**
         * 获取xml的namespace
         *
         * @param resource xml资源
         * @return java.lang.String
         * @date ：2018/12/19
         * @author ：zc.ding@foxmail.com
         */
        private String getNamespace(Resource resource) {
            try {
                XPathParser parser = new XPathParser(resource.getInputStream(), true, null, new XMLMapperEntityResolver());
                return parser.evalNode("/mapper").getStringAttribute("namespace");
            } catch (Exception e) {
                throw new RuntimeException("ERROR: 解析xml中namespace失败", e);
            }
        }
    }
}
