package com.wanglei.controller;

import com.wanglei.service.StockService;
import com.wanglei.service.UserService;
import com.wanglei.transactional.MyTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;
    @Autowired
    private StockService stockService;

    static {

        System.out.println("初始化了Controller");
    }

    @RequestMapping("test")
    @ResponseBody
    public void test(){

        userService.printA("A");
        stockService.printB("B");
    }

    @RequestMapping("test1")
    @ResponseBody
    public void test1(){
        userService.getUser();
        stockService.getStock();
    }

}
