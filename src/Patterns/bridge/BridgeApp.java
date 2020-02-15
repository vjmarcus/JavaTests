package Patterns.bridge;

public class BridgeApp {
    public static void main(String[] args) {
        Car car = new Sedan(new Skoda());
        car.showDetails();
        Car car1 = new Hatchback(new Kia());
        car1.showDetails();
    }
}
abstract class Car {
    Make make;

    public Car(Make make) {
        this.make = make;
    }
    abstract void showDetails();
}
class Sedan extends Car{
    @Override
    void showDetails() {
        System.out.println("SEDAN");
        make.setMake();
    }

    public Sedan(Make make) {
        super(make);
    }
}
class Hatchback extends Car {
    @Override
    void showDetails() {
        System.out.println("HATCHBACK");
        make.setMake();
    }

    public Hatchback(Make make) {
        super(make);
    }
}

interface Make{
    void setMake();
}
class Kia implements Make {
    @Override
    public void setMake() {
        System.out.println("KIA");
    }
}
class Skoda implements Make {
    @Override
    public void setMake() {
        System.out.println("SKODA");
    }
}