package com.wanglei.business.controller;

import com.wanglei.business.model.Student;
import com.wanglei.business.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockAction extends BaseAction {

    @Autowired
    private StockService stockService;

    @RequestMapping("getStock")
    public List<Integer> getStockList(Student student) {
        System.out.println(student);
        List<Integer> stockList = stockService.getStockList();
        return stockList;
    }

    @RequestMapping("getStock1")
    public List<Integer> getStock1List(Student student) {
        System.out.println(student);
        List<Integer> stockList = stockService.getStockList();
        return stockList;
    }
}
