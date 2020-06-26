package com.wanglei.business;

import org.springframework.aop.framework.ProxyFactoryBean;

public class Car {

    private String name;

    public static void main(String[] args) throws ClassNotFoundException {
        ProxyFactoryBean proxyFactoryBean=new ProxyFactoryBean();
        proxyFactoryBean.setTarget(null);
        proxyFactoryBean.setInterceptorNames("");
        Class [] my={Car.class};
        proxyFactoryBean.setProxyInterfaces(my);
        Integer a=128;
        Integer b=128;
        System.out.println(a!=b);
        a.intValue();
    }


}
