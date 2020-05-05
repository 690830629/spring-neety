package com.wanglei.business.stream;

import com.google.common.collect.Lists;
import com.wanglei.business.model.User;

import java.util.List;

public class BaseStreamData {

    public static List<User> getUserList() {
        List<User> users = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            User user = new User(i);
            users.add(user);
        }
        User user = new User(1);
        users.add(user);
        User user2 = new User(2);
        users.add(user2);
        return users;
    }
}
