package com.wanglei.config;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    static {
        System.out.println("初始化了MyComponent");
    }

    private String height;
}
