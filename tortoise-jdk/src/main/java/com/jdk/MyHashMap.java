package com.jdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
        ConcurrentHashMap<String,String> concurrentHashMap =new ConcurrentHashMap<>();
        concurrentHashMap.put("1","1");
        concurrentHashMap.get("1");

    }
}
