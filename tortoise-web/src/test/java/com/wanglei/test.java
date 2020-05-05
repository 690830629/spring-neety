package com.wanglei;

import com.wanglei.business.model.Student;
import com.wanglei.business.thread.MyThread;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test extends BaseTest {

    @Autowired
    private Student student;

    @Autowired
    private MyThread myThread;


    @Test
    public void getUserTest() {
        System.out.println(student);
        System.out.println(student);

    }

    @Test
    public void getMyThread()  {
        myThread.syncData();

    }
}
