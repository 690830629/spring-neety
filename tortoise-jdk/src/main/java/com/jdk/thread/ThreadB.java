package com.jdk.thread;

public class ThreadB extends Thread {


    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(3000);
                myService.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
