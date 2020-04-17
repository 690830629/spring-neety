package com.wanglei;

import com.wanglei.business.model.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test extends BaseTest {

    @Autowired
    private Student student;


    @Test
    public void getUserTest() {
        System.out.println(student);
        System.out.println(student);

    }
}
