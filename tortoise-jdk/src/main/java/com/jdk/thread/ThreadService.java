package com.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadService {
    ReentrantLock lock=new ReentrantLock();

    public  void service() throws InterruptedException {
        Condition condition = lock.newCondition();
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        condition.await();




    }
}
