package multithreading;

public class Main {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("MyThread1");
        MyThread myThread2 = new MyThread("MyThread2");
        MyThread myThread3 = new MyThread("MyThread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        System.out.println("Hello from Main Thread");
        Thread thread = new Thread(new MySecondThread());
        thread.start();
    }
}

// 1 variant
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println("Hello from MyThread" + getName());
        }
    }
}
// 2 variant
class MySecondThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println("Hello from MySecondThread");
        }
    }
}
