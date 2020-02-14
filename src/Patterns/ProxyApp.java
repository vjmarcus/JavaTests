package Patterns;

public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("D:/image/image.jpg");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {

    String file;

    public RealImage(String file) {
        this.file = file;
        loadFile();
    }

    void loadFile() {
        System.out.println("Загрузка файла " + file);
    }

    @Override
    public void display() {
        System.out.println("Просмотр файла " + file);
    }
}

class ProxyImage implements Image {

    String file;
    RealImage realImage;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}
