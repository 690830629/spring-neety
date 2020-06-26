package com.jdk;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatt {
    private static final Pattern STARTS_WITH_ASCII_PATTERN = Pattern.compile("^\\p{ASCII}+.*");

    public static void main(String[] args) {
        String name="ET聚场";
        Matcher matcher = STARTS_WITH_ASCII_PATTERN.matcher(name);

       if(matcher.matches()) {
           System.out.println("匹配");
       }
        int a=35;
       int b=10;
        double fff = 184d / 20d;
        System.out.println(  Math.ceil(fff));
        System.out.println(Math.ceil(a/b));

    }
}
