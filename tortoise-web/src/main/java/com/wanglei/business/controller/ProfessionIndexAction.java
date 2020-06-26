package com.wanglei.business.controller;

import com.wanglei.business.dao.ProfessionIndexMapper;
import com.wanglei.business.model.ProfessionIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class ProfessionIndexAction {

    @Autowired
    private ProfessionIndexMapper professionIndexMapper;

    @RequestMapping(value = "getIndex", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfessionIndex getIndex() throws ParseException {
        ProfessionIndex byProjectIdAndCreateTime = professionIndexMapper.getByProjectIdAndCreateTime(89150, new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-06"));
        return byProjectIdAndCreateTime;
    }


}
