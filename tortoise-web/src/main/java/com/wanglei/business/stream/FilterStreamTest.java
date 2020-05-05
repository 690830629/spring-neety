package com.wanglei.business.stream;

import com.wanglei.business.model.User;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterStreamTest extends BaseStreamData {

    public static void main(String[] args) {
        List<User> collect = getUserList().stream().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getHeight() == 1;
            }
        }).collect(Collectors.toList());
        System.out.println(collect);
        getUserList().stream().filter(e->e.getHeight()==1);
        List<User> collect1 = getUserList().stream().filter(User::isHeighter).collect(Collectors.toList());
        System.out.println(collect1);
    }

}
