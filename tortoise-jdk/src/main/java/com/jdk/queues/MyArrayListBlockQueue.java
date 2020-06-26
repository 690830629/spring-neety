package com.jdk.queues;

import java.util.AbstractQueue;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyArrayListBlockQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> myQueue=new ArrayBlockingQueue(10);
        myQueue.put(1);
        myQueue.take();
        myQueue.peek();
        myQueue.poll();
        myQueue.add(1);
    }
}
