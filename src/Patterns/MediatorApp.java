package Patterns;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {

        TextChat chat = new TextChat();
        Client admin = new Admin(chat);
        Client client1 = new SimpleClient(chat);
        Client client2 = new SimpleClient(chat);
        chat.setAdmin(admin);
        chat.addClient(client1);
        chat.addClient(client2);
        client1.sendMessage("Привет, я пользователь!");
        admin.sendMessage("Привет, я Админ!");
    }
}
interface Client {
    void sendMessage(String message);
    void getMessage(String message);
}
interface Chat{
    void sendMessage(String message, Client client);
}
class Admin implements Client{
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Администратор получает сообщение " + message);

    }
}
class SimpleClient implements Client{
    Chat chat;

    public SimpleClient(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь получает сообщение " + message);

    }
}
class TextChat implements Chat{
    Client admin;
    List <Client> clients = new ArrayList<>();

    public void setAdmin(Client admin) {
        this.admin = admin;
    }
    public void addClient(Client client){
        clients.add(client);
    }

    @Override
    public void sendMessage(String message, Client client) {
        for (Client client1: clients) {
            client1.getMessage(message);
        }
        admin.getMessage(message);
    }
}