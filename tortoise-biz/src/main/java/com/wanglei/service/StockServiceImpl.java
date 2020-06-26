package com.wanglei.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class StockServiceImpl implements StockService {
    @Override
    public void printB(String B) {
        System.out.println(B);
    }

    @Override
    public void getStock() {
        System.out.println("没有库存");
    }
}
