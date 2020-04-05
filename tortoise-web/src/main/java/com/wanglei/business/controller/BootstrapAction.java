package com.wanglei.business.controller;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BootstrapAction {

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public List<String> getBootstrapParameter(){
        System.out.println("执行");
        List<String> name= Lists.newArrayList("王蕾");
        return name;
    }
}
