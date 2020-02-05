package solid.right;

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {

        // В параметрах нельзя указывать интерфейсы, поэтому передаем их реализацию, их классы
        Phone phone = new Phone(new ConnectionManagerImplementation(), new DataManagerImplementation());
        phone.dial("234234234234");
        phone.receive();
        phone.send("Hello!");
        phone.disconnect();
    }
}

interface IConnectionManager{
    void dial(String phoneNumber);
    void disconnect();
}
interface IDataManager{
    void send(String message);
    int receive();
}
class ConnectionManagerImplementation implements IConnectionManager{
    @Override
    public void dial(String phoneNumber) {
        System.out.println("Connection established");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected successfully");
    }
}
class DataManagerImplementation implements IDataManager{
    @Override
    public void send(String message) {
        System.out.println("Data send successfully");
    }

    @Override
    public int receive() {
        System.out.println("data received successfully");
        return 0;
    }
}
class Phone implements IDataManager, IConnectionManager{

    private IConnectionManager connectionManager;
    private IDataManager dataManager;

    public Phone(IConnectionManager connectionManager, IDataManager dataManager) {
        this.connectionManager = connectionManager;
        this.dataManager = dataManager;
    }

    @Override
    public void dial(String phoneNumber) {
        connectionManager.dial(phoneNumber);
    }

    @Override
    public void disconnect() {
        connectionManager.disconnect();
    }

    @Override
    public void send(String message) {
        dataManager.send(message);
    }

    @Override
    public int receive() {
        return dataManager.receive();
    }
}