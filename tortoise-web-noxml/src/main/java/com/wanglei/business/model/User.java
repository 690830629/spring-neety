package com.wanglei.business.model;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
public class User {

    static {
        System.out.println("初始化了user");
    }

    private String name;

    private int age;
}
