package com.wanglei.business.spring;

import com.wanglei.business.controller.BootstrapAction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath*:config/spring/applicationContext-mvc.xml");
        BootstrapAction bootstrapAction = (BootstrapAction)classPathXmlApplicationContext.getBean("BootstrapAction");
        System.out.println(bootstrapAction);
    }
}
