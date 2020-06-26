package com.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadNameTask {

    public static void main(String[] args) {
        Lock lock=new ReentrantLock(false);
        Condition condition = lock.newCondition();
        PrintThreadNameTask printThreadNameTask=new PrintThreadNameTask(lock,condition);
        SetThreadNameTask setThreadNameTask=new SetThreadNameTask(lock,condition);
        Thread a=new Thread(printThreadNameTask);
        a.setName("我是a线程");
        a.start();
        Thread b=new Thread(printThreadNameTask);
        b.setName("我是b线程");
        b.start();
        Thread c=new Thread(printThreadNameTask);
        c.setName("我是c线程");
        c.start();
        Thread d=new Thread(setThreadNameTask);
        d.setName("我是d线程");
        d.start();

    }
}
