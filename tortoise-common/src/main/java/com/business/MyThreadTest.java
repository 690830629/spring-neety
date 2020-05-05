package com.business;

public class MyThreadTest {



    public static void main(String[] args) {
        MyThread task = new MyThread();
        Thread t1=new Thread(task);
        Thread t2=new Thread(task);
        Thread t3=new Thread(task);
        t1.setName("a");
        t1.start();
        t2.setName("b");
        t2.start();
        t3.setName("c");
        t3.start();
    }


}
