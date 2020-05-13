package com.wanglei.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserAction {
    static {
        System.out.println("初始化了Controller");
    }
}
