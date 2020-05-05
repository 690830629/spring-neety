package com.business;

public class MyThread implements Runnable {
    int i=0;
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"=======进入");
        i++;
        System.out.println(name+"========离开"+i);

    }
}
