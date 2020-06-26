package semaphore;

import java.util.concurrent.Semaphore;

public class MySemaphoreTest {
    static class TaskThread extends Thread {

        private Semaphore semaphore;

        public TaskThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquire");
                Thread.sleep(10000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " release");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        int threadNum = 10;
        for (int i = 0; i < threadNum; i++) {
            new TaskThread(semaphore).start();
        }
    }
}
