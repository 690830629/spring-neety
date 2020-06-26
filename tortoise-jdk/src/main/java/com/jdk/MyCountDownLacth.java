package com.jdk;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLacth {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(10);
        countDownLatch.await();
        countDownLatch.countDown();
    }
}
