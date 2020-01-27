package Patterns;

public class BuilderApp {
    public static void main(String[] args) {

        // 5. Строим машину через CarBuilderSimple
        Car car = new CarBuilderSimple()
                .buildMake("Mercedes")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(200)
                .build();
        System.out.println(car);

        // 7. Строим машину через Director
        Director director = new Director();
        director.setCarBuilder(new SubaruBuilder());
        Car car1 = director.BuildCar();
        System.out.println(car1);

        // 8. Достаточно передать другой Билдер и получим другую машину
        Director director1 = new Director();
        director1.setCarBuilder(new FordMondeoBuilder());
        Car carFord = director1.BuildCar();
        System.out.println(carFord);
    }
}


enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [make= " + make + ", transmission " + transmission + ", MaxSpeed " + maxSpeed + "]";
    }
}

// 6. Более сложная реализация без CarBuilder
abstract class CarBuilder {
    Car car;

    void createCar() {
        car = new Car();
    }

    abstract void buildMake();

    abstract void buildTransmission();

    abstract void buildMaxSpeed();

    Car getCar() {
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(200);
    }
}
class SubaruBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Subaru Forester");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(270);
    }
}

class Director {
    CarBuilder carBuilder;
    void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

        Car BuildCar() {
        carBuilder.createCar();
            carBuilder.buildMake();
            carBuilder.buildTransmission();
            carBuilder.buildMaxSpeed();
            Car car = carBuilder.getCar();
            return car;
        }
    }




// 1. Класс, который строит машину
class CarBuilderSimple {

    // 2. Ставим дефолтные значения
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s = 120;

    // 3. Методы, которые позволяют модифицировать эти значения
    CarBuilderSimple buildMake(String m) {
        this.m = m;
        return this;
    }

    CarBuilderSimple buildTransmission(Transmission t) {
        this.t = t;
        return this;
    }

    CarBuilderSimple buildMaxSpeed(int s) {
        this.s = s;
        return this;
    }

    // 4. Метод, который возвращает машину со свойствами из пункта 2
    Car build() {
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}








