package com.wanglei.business.stream;

import com.wanglei.business.model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByStreamTest extends BaseStreamData {


    public static void main(String[] args) {

        Map<Integer, List<User>> collect = getUserList().stream().collect(Collectors.groupingBy(User::getHeight));
        System.out.println(collect);
    }
}
