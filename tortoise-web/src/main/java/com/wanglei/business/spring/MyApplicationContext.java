package com.wanglei.business.spring;

import com.wanglei.business.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath*:config/spring/applicationContext-mvc.xml");
        UserService getBeanTest = (UserService) classPathXmlApplicationContext.getBean("userServiceFactoryBean");
        System.out.println(getBeanTest);
        classPathXmlApplicationContext.refresh();
    }


}
