package multithreading.volatile_example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread());
        myThread.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }
}

class MyThread implements Runnable {
    private volatile boolean isRunning = true;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread!");
        }
    }
    public void shutDown() {
        isRunning = false;
    }
}
