package com.jdk.queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class MyQueue {
    private static final BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque(10);
    public static void main(String[] args) throws InterruptedException {
        // 如何对列已满 则抛异常
        MyQueue.blockingQueue.add(1);
        // 如何对列已满 则阻塞
        MyQueue.blockingQueue.put(1);
        // 如何对列已满 返回false
        MyQueue.blockingQueue.offer(1);


        // 如果对列已空 则阻塞
        MyQueue.blockingQueue.take();

        // 出对列
        MyQueue.blockingQueue.poll();


        MyQueue.blockingQueue.peek();


        for(int i=0;i<8;i++){
            System.out.println( MyQueue.blockingQueue.offer(i));
        }
        System.out.println(MyQueue.blockingQueue.size());

        MyQueue.blockingQueue.poll();
        System.out.println(MyQueue.blockingQueue.size());

    }
}
