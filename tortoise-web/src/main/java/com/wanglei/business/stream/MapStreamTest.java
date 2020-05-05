package com.wanglei.business.stream;

import com.wanglei.business.model.User;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapStreamTest extends BaseStreamData {
    public static void main(String[] args) {
        // 这种情况下要保证key是唯一的 否则会抛出异常; Duplicate key User(height=1)
//        Map<Integer, User> collect = getUserList().stream().collect(Collectors.toMap(User::getHeight, Function.identity()));
//        System.out.println(collect);
        List<Integer> collect1 = getUserList().stream().map(User::getHeight).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
