package com.wanglei.business.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        List<Callable<Void>> list= Lists.newArrayList();
//        for(int i=0;i<10;i++){
//            list.add(new Callable<Void>() {
//                @Override
//                public Void call() throws Exception {
//                    System.out.println(Thread.currentThread().getName());
//                    return null;
//                }
//            });
//        }
//        scheduledExecutorService.invokeAll(list);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        },0,3,TimeUnit.SECONDS);

    }
}
