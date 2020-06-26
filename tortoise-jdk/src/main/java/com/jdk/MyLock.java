package com.jdk;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();
        condition.signalAll();
        // 没有看到阻塞相关的东西  true // false
        lock.tryLock();
        // 区别 // 去争抢锁 那不到锁会阻塞在那里
        lock.lock();
        // 去唤醒下一个不被取消的节点 从尾结点开始遍历往前找
        lock.unlock();

    }
}
