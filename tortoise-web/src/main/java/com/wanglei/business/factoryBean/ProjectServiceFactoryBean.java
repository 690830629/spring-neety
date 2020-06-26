package com.wanglei.business.factoryBean;

import com.wanglei.business.proxy.JDKProxySubject;
import com.wanglei.business.service.ProjectService;
import com.wanglei.business.service.ProjectServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Proxy;

public class ProjectServiceFactoryBean implements FactoryBean, InitializingBean {

    private ProjectService projectService;

    @Override
    public void afterPropertiesSet() throws Exception {
        projectService = (ProjectService) Proxy.newProxyInstance(ProjectServiceFactoryBean.class.getClassLoader(), new Class[]{ProjectService.class}, new JDKProxySubject(new ProjectServiceImpl()));
    }

    @Override
    public ProjectService getObject() throws Exception {

        return projectService;
    }

    @Override
    public Class<?> getObjectType() {
        return ProjectService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
