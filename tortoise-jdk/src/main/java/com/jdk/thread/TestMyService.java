package com.jdk.thread;

public class TestMyService {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        threadA.setName("A");
        threadA.start();
        threadB.setName("B");
        threadB.start();


    }
}
