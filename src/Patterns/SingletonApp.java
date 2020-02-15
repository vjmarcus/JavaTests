package Patterns;

public class SingletonApp {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++){
            Thread thread = new Thread(new R());
            thread.start();
        }
        System.out.println(Singleton.counter);
    }
}

class Singleton {
    public static int counter = 0;
    private static Singleton instance = new Singleton();

    private Singleton(){
    }
    public static Singleton getInstance(){
        counter++;
        return instance;
    }
}

//class Singleton {
//    public static int counter = 0;
//    private static Singleton instance;
//
//    private Singleton(){
//    }
//    public static Singleton getInstance(){
//        counter++;
//        if (instance == null) {
//            instance = new Singleton();
//        }
//            return instance;
//    }
//}
class R implements Runnable{
    @Override
    public void run() {
        Singleton.getInstance();
    }
}
