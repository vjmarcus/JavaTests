package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Person> personQueue = new ArrayBlockingQueue<Person>(5);
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        personQueue.add(person4);
        personQueue.add(person1);
        personQueue.add(person2);
        personQueue.add(person3);

        for (Person person: personQueue) {
            System.out.println(person);
        }

    }
}

class Person {

    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}