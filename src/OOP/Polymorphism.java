package OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        Dancer breakDancer = new BreakDancer();
        Dancer tangoDancer = new TangoDancer();
        ArrayList<Dancer> list = new ArrayList<>();
        list.add(breakDancer);
        list.add(tangoDancer);

        // Каждый танцор вызывает свой метод
        for (Dancer dancer : list) {
            dancer.dance();
            /*Вывод:
            Я танцую Брейк!
            Я танцую танго!
            * */
        }

        Swim human = new Human(35, "Олег");
        Swim fish = new Fish("Gold Fish");
        List<Swim> swimList = Arrays.asList(human, fish);
        for (Swim swim: swimList) {
            swim.swim();
        }
    }
}

class Dancer {
    void dance() {
        System.out.println("Мама, я танцую!");
    }
}

class BreakDancer extends Dancer {
    void dance() {
        System.out.println("Я танцую Брейк!");
    }
}

class TangoDancer extends Dancer {
    void dance() {
        System.out.println("Я танцую танго!");
    }
}

interface Swim{
    void swim();
}

class Human implements Swim{
    private  int age;
    private  String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println("Я плаваю с помощью надувного круга");
    }
}

class Fish implements Swim{
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println("Я плаваю двигая плавниками и хвостом");
    }
}
