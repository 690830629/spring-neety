package com.wanglei.business.stream;

import com.wanglei.business.model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByStreamTest extends BaseStreamData {
    public static void main(String[] args) {
        List<User> userList = getUserList();
        Map<Boolean, List<User>> collect = userList.stream().collect(Collectors.partitioningBy(User::isHeighter));
        System.out.println(collect);
    }
}
