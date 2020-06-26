package com.wanglei.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService  {
    @Override
    public void printA(String A) {
        System.out.println(A);
    }

    @Override
    public void getUser() {
        System.out.println("没有用户");
    }
}
