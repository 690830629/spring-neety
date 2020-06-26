package com.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    private boolean hasValue = false;

    public void set() throws InterruptedException {
        lock.lock();
        if (hasValue == true) {
            condition.await();
        }
        System.out.println("我是" + Thread.currentThread().getName());
        hasValue = false;
        condition.signal();
        lock.unlock();
    }

    public void get() throws InterruptedException {
        lock.lock();
        if (hasValue == false) {
            condition.await();
        }
        System.out.println("我是" + Thread.currentThread().getName());
        hasValue = true;
        condition.signal();
        lock.unlock();
    }
}
