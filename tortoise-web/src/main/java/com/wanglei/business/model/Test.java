package com.wanglei.business.model;

public class Test {


    private static void build(User user){
        user.setHeight(2000);
        user=new User();
        user.setHeight(1000);
    }
    public static void main(String[] args) {
        User user=new User();
        build(user);
        System.out.println(user);
    }
}
