package com.wanglei.business.controller;

import com.wanglei.business.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionAction {

    @ResponseBody
    @RequestMapping(value = "/e")
    public void getMyStudent() {

        Student a = null;
        a.getName();


    }
}
