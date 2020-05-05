package com.wanglei.business.proxy;

import com.wanglei.business.service.ProjectService;
import com.wanglei.business.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxySubject implements InvocationHandler {


    private ProjectService projectService;


    public JDKProxySubject(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object invoke = method.invoke(projectService, args);
        System.out.println("结束");
        return invoke;
    }
}
