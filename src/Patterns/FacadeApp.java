package Patterns;

public class FacadeApp {
    public static void main(String[] args) {

        Computer computer = new Computer();

// 2. Вызываем метод, который делает всю работу

        computer.copy();
    }
}

//  1. После создания вспомогательных классов делаем управляющий класс, куда помещаем экземпляры наших запчастей
class Computer {
    Power power = new Power();
    DVDRoom dvdRoom = new DVDRoom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvdRoom.load();
        hdd.copyFromDVD(dvdRoom);
        power.off();
    }
}

class Power {
    void on() {
        System.out.println("Power ON");
    }

    void off() {
        System.out.println("Power OFF");
    }
}

class DVDRoom {
    private boolean isData = false;

    public boolean hasData() {
        return isData;
    }

    void load() {
        isData = true;
    }

    void unload() {
        isData = false;
    }
}

class HDD {
    void copyFromDVD(DVDRoom dvdRoom) {
        if (dvdRoom.hasData()) {
            System.out.println("Copy working");
        } else {
            System.out.println("Enter disk with data");
        }
    }
}
