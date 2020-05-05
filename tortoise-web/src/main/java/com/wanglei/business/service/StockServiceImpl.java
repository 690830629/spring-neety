package com.wanglei.business.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Override
    public List<Integer> getStockList() {
        return Lists.newArrayList(100);
    }
}
