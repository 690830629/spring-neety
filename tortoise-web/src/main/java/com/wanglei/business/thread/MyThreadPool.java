package com.wanglei.business.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
    }
}
