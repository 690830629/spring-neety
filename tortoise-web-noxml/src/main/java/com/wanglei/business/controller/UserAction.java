package com.wanglei.business.controller;

import com.google.common.collect.Lists;
import com.wanglei.business.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAction {

    @RequestMapping(value = "user/getUserList")
    public void getUserList() {
        List<User> userList = Lists.newArrayList();
        User user = new User();
        user.setAge(27);
        user.setName("王蕾");
        userList.add(user);
        System.out.println("进入了controller");
    }

    static {
        System.out.println("初始化了userAction");
    }
}
