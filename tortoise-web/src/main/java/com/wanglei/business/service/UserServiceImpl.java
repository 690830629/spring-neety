package com.wanglei.business.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<String> getUserList() {

        List list = Lists.newArrayList(1, 2, 3, 4);
        return list;
    }


}
