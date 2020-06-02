package callbacks;



public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        MyClass myClass = new MyClass();
        main.registerCallback(myClass);
        main.doSomething();
    }

    private Callback callback;
    private String replyTo;


    public void registerCallback(Callback callback) {
        this.callback = callback;
    }
    void doSomething() {
        System.out.println("Работаем...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.callingBack("работа выполнена");
    }
}