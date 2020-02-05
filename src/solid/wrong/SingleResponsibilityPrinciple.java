package solid.wrong;

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        IPhone phone = new Phone();
        phone.dial("234234234");
        phone.disconnect();
        phone.receive();
    }
}
// Интерфейс нарушает принципы SRP, потому что не точно отображает, зачем он создан. У него несколько обязанностей, две зависимости.
interface IPhone{

    // Два метода отвечают за связь
    void dial(String phoneNumber);
    void disconnect();
    // Два метода отвечают за информацию
    void send(String message);
    int receive();
}
class Phone implements IPhone{
    @Override
    public void dial(String phoneNumber) {
        System.out.println("Connect established");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");
    }

    @Override
    public void send(String message) {
        System.out.println("Data send successfully");
    }

    @Override
    public int receive() {
        System.out.println("Data received successfully");
        return 0;
    }
}