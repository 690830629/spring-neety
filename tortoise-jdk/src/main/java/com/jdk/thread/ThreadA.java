package com.jdk.thread;

public class ThreadA extends Thread {


    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(3000);
                myService.set();

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
