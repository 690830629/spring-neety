package com.jdk.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PrintThreadNameTask implements Runnable {

    private Lock lock;

    private Condition condition;

    public PrintThreadNameTask(Lock lock,Condition condition) {
        this.lock = lock;
        this.condition=condition;
    }

    @Override
    public void run() {
        lock.lock();
        for (int i = 0; i < 3; i++) {
            try {
                condition.await();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}
