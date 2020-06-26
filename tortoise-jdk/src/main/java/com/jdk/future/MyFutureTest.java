package com.jdk.future;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFutureTest {



    public static class MyFutureTask implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyFutureTask myFutureTask = new MyFutureTask();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        java.util.concurrent.Future<Integer> submit = executorService.submit(myFutureTask);
        submit.get();
    }
}
