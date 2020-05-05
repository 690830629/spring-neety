package com.wanglei.business.proxy;

import com.wanglei.business.service.ProjectService;
import com.wanglei.business.service.ProjectServiceImpl;
import com.wanglei.business.service.UserService;
import com.wanglei.business.service.UserServiceImpl;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        UserService proxyInstance = (UserService)Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{ ProjectService.class}, new JDKProxySubject(new ProjectServiceImpl()));
        proxyInstance.getUserList();
    }
}
