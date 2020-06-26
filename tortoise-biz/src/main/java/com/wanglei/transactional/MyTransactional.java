package com.wanglei.transactional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyTransactional {

    @Transactional
    public void get() {
        System.out.println("触发了事物");
    }
}
