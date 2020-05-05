package com.wanglei.business.stream;

import com.wanglei.business.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class SetStreamTest extends BaseStreamData {
    public static void main(String[] args) {
        Set<User> collect = getUserList().stream().collect(Collectors.toSet());
        System.out.println(collect);

    }
}
