package com.wanglei.business.controller;

import com.google.common.collect.Lists;
import com.wanglei.business.thread.MyThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BootstrapAction extends BaseAction {


//    @Autowired
//    private Student student;

    @Autowired
    private MyThread myThread;

    @RequestMapping(value = {"/test","test/ha"},method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public List<String> getBootstrapParameter(){
        System.out.println("执行");
        List<String> name= Lists.newArrayList("王蕾");
        return name;

    }
    @RequestMapping(value = {"/dog/{id}"},method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public List<String> getBootstrapParameter(@PathVariable (value = "id") int id){
        System.out.println("执行");
        List<String> name= Lists.newArrayList("王蕾");
        return name;

    }

    @RequestMapping(value = "/index/abd" ,method = RequestMethod.GET)
    @ResponseBody
    public String getIndex(){
        System.out.println("执行");
        return "index";
    }
    @RequestMapping(value = "/b/r/e" ,method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    public void getBootstrapParameterf(){
        System.out.println("执行");


    }

    @RequestMapping(value = "/test1" ,method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public void syncData() throws InterruptedException {
        myThread.syncData();


    }


}
