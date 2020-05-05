package com.wanglei.business.proxy;

import com.wanglei.business.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {


    private UserService userService;

    public UserService getProxyInstance() {
        Object o = Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(), new Class[]{UserService.class}, this);
        return (UserService) o;
    }

    MyInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object invoke = method.invoke(userService, args);
        System.out.println("结束");

        return invoke;
    }
}
