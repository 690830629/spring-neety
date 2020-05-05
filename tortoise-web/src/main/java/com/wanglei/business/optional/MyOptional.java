package com.wanglei.business.optional;

import com.google.common.collect.Lists;
import com.wanglei.business.model.User;
import com.wanglei.business.stream.BaseStreamData;

import java.util.List;
import java.util.Optional;

public class MyOptional extends BaseStreamData {
    public static void main(String[] args) {
        List<User> listUser=null;
        Optional<List<User>> userList = Optional.ofNullable(listUser);

        List<User> userListElse=Lists.newArrayList();
        User user=new User(100);
        userListElse.add(user);

        System.out.println( userList.orElse(userListElse));
    }
}
