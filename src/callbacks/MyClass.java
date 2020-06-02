package callbacks;

public class MyClass implements Callback {


    @Override
    public void callingBack(String s) {
        System.out.println("Вызов метода обратного вызова и сообщение = " + s);
    }
}
