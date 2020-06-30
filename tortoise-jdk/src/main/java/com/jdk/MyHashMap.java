package com.jdk;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap {
    public static void main(String[] args) {
//        String str=new String("1");
//        str.hashCode();
//        Object object=new Object();
//        object.hashCode();
        HashMap<String,String> map=new HashMap<>();
        map.put("1","1");
        map.get("1");
        map.size();
        ConcurrentHashMap<String,String> concurrentHashMap =new ConcurrentHashMap<>();
        concurrentHashMap.put("1","1");
        concurrentHashMap.get("1");
        concurrentHashMap.size();
         final int NCPU = Runtime.getRuntime().availableProcessors();
        System.out.println(NCPU);


    }
}
