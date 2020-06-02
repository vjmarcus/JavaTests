package multithreading.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            service.submit(new Processor(i, countDownLatch));
        }
        service.shutdown();
        countDownLatch.await();
        System.out.println("Latch has been opened, main thread is proceeding!");
    }
}

class Processor implements Runnable {

    private int i;
    private CountDownLatch countDownLatch;

    public Processor(int i, CountDownLatch countDownLatch) {
        this.i = i;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println("Thread " + i + " proceed.");
    }
}
