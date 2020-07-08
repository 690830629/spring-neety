package com.wanglei.business.designpatterns.chain;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wanglei105
 * @version 1.0
 * @date 2020/7/4 下午2:06
 */
public class SaveProfessor extends Thread implements IRequestProcessor {

    // 阻塞队列
    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish = false;

    public SaveProfessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public SaveProfessor() {
    }

    public void shutdown() {

        isFinish = true;
    }


    @Override
    public void process(Request request) {
        // todo
        // 根据实际需求处理
        requests.add(request);
    }

    @Override
    public void run() {
        while (!isFinish) {
            try {
                // 跟阻塞相关的为什么会抛异常？
                Request request = requests.take();
                System.out.println("saveProfessor" + request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
