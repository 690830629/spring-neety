package com.wanglei.business.designpatterns.chain;

/**
 * @author wanglei105
 * @version 1.0
 * @date 2020/7/4 下午2:19
 */
public class App {


    static IRequestProcessor requestProfessor;

    public App() {

    }

    public void setUp() {
        PrintProcessor printProcessor = new PrintProcessor();
        printProcessor.start();
        SaveProfessor saveProfessor = new SaveProfessor(printProcessor);
        saveProfessor.start();
        requestProfessor = new PrevProcessor(saveProfessor);
        ((PrevProcessor) requestProfessor).start();
    }

    public static void main(String[] args) {
        App app = new App();
        app.setUp();
        Request request = new Request();
        request.setName("王蕾");
        requestProfessor.process(request);
    }
}
