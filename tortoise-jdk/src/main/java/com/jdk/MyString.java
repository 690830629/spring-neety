package com.jdk;

import java.util.HashMap;

public class MyString {
    public static void main(String[] args) {
        HashMap<User,String> map=new HashMap();
        map.put(new User(1),"1");
        String s = map.get(new Dog(1));
        String s1 = map.get(new User(1));
        System.out.println(s);
        System.out.println(s1);
    }
}
