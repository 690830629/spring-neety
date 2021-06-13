package com.wanglei.business;

import org.springframework.aop.framework.ProxyFactoryBean;

import java.util.TreeMap;

public class Car {

    private String name;

    public static void main(String[] args) throws ClassNotFoundException {
        TreeMap<Integer, Integer> treeMap = new TreeMap();

        treeMap.put(1, 3);
        treeMap.get(2);
        System.out.println(1);
    }
}