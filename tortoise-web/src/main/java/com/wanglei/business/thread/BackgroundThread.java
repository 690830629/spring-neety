package com.wanglei.business.thread;

public class BackgroundThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        System.out.println("还真执行了");

    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        BackgroundThread ba = new BackgroundThread();
        ba.start();
    }
}
