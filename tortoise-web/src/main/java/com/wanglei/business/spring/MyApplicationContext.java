package com.wanglei.business.spring;

import com.wanglei.business.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath*:config/spring/applicationContext-mvc.xml");
        UserService getBeanTest = (UserService) classPathXmlApplicationContext.getBean("userServiceFactoryBean");
        System.out.println(getBeanTest);
    }
}
