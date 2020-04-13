package wildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        List<Animal> listOfAnimals = new ArrayList<>();
        listOfAnimals.add(new Animal(1));
        listOfAnimals.add(new Animal(2));

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog(1));
        listOfDogs.add(new Dog(2));

        test(listOfAnimals);
        test(listOfDogs);
    }

    private static void test(List<? extends Animal> animalList) {
        for (Animal animal: animalList) {
            System.out.println(animal.id);
        }
    }

}
class Animal{
    int id;

    public Animal(int id) {
        this.id = id;
    }
}
class Dog extends Animal{

    public Dog(int id) {
        super(id);
    }
}
