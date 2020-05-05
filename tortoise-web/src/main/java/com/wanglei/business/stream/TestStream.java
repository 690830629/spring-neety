package com.wanglei.business.stream;

import com.wanglei.business.model.User;

import java.util.List;
import java.util.function.Consumer;

public class TestStream extends BaseStreamData {
    public static void main(String[] args) {
        List<User> userList = getUserList();
        System.out.println(userList);
        userList.stream().forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                if( user.getHeight()==1 || 2==user.getHeight()){

                }

            }
        });
        userList.stream().forEach(e->e.getHeight());

    }
}
