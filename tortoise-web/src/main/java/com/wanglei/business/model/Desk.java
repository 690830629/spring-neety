package com.wanglei.business.model;

import com.google.common.collect.Maps;
import com.wanglei.business.service.UserService;
import lombok.Data;

import java.util.Map;

@Data
public class Desk {

    private String color;

    private UserService userService;

    public void get(){
        Map<Integer,UserService> a= Maps.newHashMap();
        a.put(1,userService);
    }

    public static void main(String[] args) {
        Desk desk=null;
        desk=new Desk();

        System.out.println(desk);
     }
}
