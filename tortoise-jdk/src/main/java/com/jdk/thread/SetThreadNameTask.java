package com.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SetThreadNameTask implements Runnable {


    private Lock lock;

    private Condition condition;

    public SetThreadNameTask(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        condition.signal();


        lock.unlock();
    }
}
