package com.business;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {

    static class MyTask implements Runnable {

        private int age;

        public MyTask(int age) {
            this.age = age;
        }

        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "====进入");
            System.out.println("啥也没干");
            System.out.println(name + "离开");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 4; i++) {
            executorService.submit(new MyTask(i));

        }
        executorService.shutdown();
    }


}
