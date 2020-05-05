package com.wanglei.business.proxy;

import com.wanglei.business.service.UserService;
import com.wanglei.business.service.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MyProxy {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        UserService proxyInstance = new MyInvocationHandler(userService).getProxyInstance();
        List<String> userList = proxyInstance.getUserList();
        System.out.println(userList);
    }
}
