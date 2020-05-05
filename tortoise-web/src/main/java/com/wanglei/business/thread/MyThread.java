package com.wanglei.business.thread;

import com.wanglei.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MyThread {

    @Autowired
    private UserService userService;

    public void syncData() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new MyTask(userService, i));
        }
//        Thread.sleep(100000L);
        executorService.shutdown();
    }

    class MyTask implements Runnable {
        private int taskLabel;

        private UserService userService;

        public MyTask(UserService userService, int taskLabel) {
            this.taskLabel = taskLabel;
            this.userService = userService;
        }


        @Override
        public void run() {
            System.out.println("线程名:" + Thread.currentThread().getName() + "=======进入 开始执行任务" + taskLabel);
            try{
                List<String> userList = userService.getUserList();
                System.out.println(taskLabel + userList.toString());
            }catch (Exception e){
                e.printStackTrace();
            }


            System.out.println("线程名:" + Thread.currentThread().getName() + "=======离开 执行完了任务" + taskLabel);
        }
    }
}
