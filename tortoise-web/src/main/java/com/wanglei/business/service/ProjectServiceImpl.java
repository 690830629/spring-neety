package com.wanglei.business.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Override
    public List<Integer> getProjectList() {

        List interList = Lists.newArrayList(1, 2, 3, 4);
        return interList;
    }
}
