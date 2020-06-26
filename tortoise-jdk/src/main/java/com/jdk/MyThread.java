package com.jdk;

public class MyThread extends Thread {







    private static   boolean flag=true;

    public static  void main(String[] args) {

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                int i=0;
                while (MyThread.flag) {
                   i++;
                    System.out.println(i+"走");

                }
                System.out.println("没进去");
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyThread.flag = false;
            }
        };
        new Thread(run1).start();
        new Thread(run2).start();





    }
}
