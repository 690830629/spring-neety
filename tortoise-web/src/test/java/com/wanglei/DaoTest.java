package com.wanglei;

import com.wanglei.business.dao.UserMapper;
import com.wanglei.business.model.User;
import com.wanglei.business.thread.MyThread;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class DaoTest extends BaseTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void getUserTest() {
        List<User> userList = userMapper.getUserList();
        org.junit.Assert.assertNotNull(userList);

    }
}
