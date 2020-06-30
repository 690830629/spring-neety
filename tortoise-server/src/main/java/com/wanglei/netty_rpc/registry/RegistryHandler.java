package com.wanglei.netty_rpc.registry;

import com.google.common.collect.Lists;
import com.wanglei.netty_rpc.protocal.InvokerProtocol;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegistryHandler extends ChannelInboundHandlerAdapter {

    private List<String> classNames = Lists.newArrayList();
    private Map<String, Object> regitryMap = new ConcurrentHashMap<>();


    // 1根据一个包名将所有符合条件的class 全部扫描出来 放到一个容器中

    // 2 给每一个对应的class起一个唯一的名字 作为服务名称 保存到一个容器中
    // 3 当有客户端连接过来之后 就会获取协议内筒 InvokerProtocol 的对象
    // 4 要去注册好的容器中找到符合条件的服务

    // 5 通过远程调用provider得到返回结果 并回复给客户端

    // 有客户端连上的时候 会回调

    public RegistryHandler() {
        // 1根据一个包名将所有符合条件的class 全部扫描出来 放到一个容器中
        scannerClass("com.wanglei.netty_rpc.provider");
        // 2 给每一个对应的class起一个唯一的名字 作为服务名称 保存到一个容器中
        doRegistry();
    }

    private void doRegistry() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> i = clazz.getInterfaces()[0];
                String serviceName = i.getName();
                // 本来这里存的应该是网络路径 从配置文件中读取
                // 在调用的时候再去解析 这里直接用反射调用
                regitryMap.put(serviceName, clazz.newInstance());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 正常来说是读配置文件
    // 简单粗暴 直接扫描本地class
    private void scannerClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                scannerClass(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replace(".class", ""));
            }

        }

    }

    // 有客户端连接上的时候 会回调
    // 3 当有客户端连接过来之后 就会获取协议内筒 InvokerProtocol 的对象

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        Object result = new Object();
        InvokerProtocol request = (InvokerProtocol) msg;
        // 要去注册好的容器中找到符合条件的服务
        if (regitryMap.containsKey(request.getClassName())) {
            Object service = regitryMap.get(request.getClassName());
            Method method = service.getClass().getMethod(request.getMethodName(), request.getPrames());
            result = method.invoke(service, request.getValues());
            // 5 通过远程调用provider得到返回结果 并回复给客户端
            ctx.write(result);
            ctx.flush();
            ctx.close();
        }
        super.channelRead(ctx, msg);
    }

    // 连接发生异常的时候会回调
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
