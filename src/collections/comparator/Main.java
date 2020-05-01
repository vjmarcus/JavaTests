package collections.comparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> listOfAnimals = new ArrayList<>();
        listOfAnimals.add("cat");
        listOfAnimals.add("dog");
        listOfAnimals.add("elephant");
        listOfAnimals.add("bird");
        Collections.sort(listOfAnimals);

        System.out.println(listOfAnimals);

        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(0);
        listOfNumbers.add(7);
        listOfNumbers.add(1);
        listOfNumbers.add(5);
        Collections.sort(listOfNumbers);

        System.out.println(listOfNumbers);
        Collections.sort(listOfAnimals, new StringLengthComparator());
        System.out.println(listOfAnimals);

//        Collections.sort(listOfNumbers, new IntegerSmallerComparator());
//        System.out.println(listOfNumbers );
        // Можно также просто создать анонимный класс сразу
        Collections.sort(listOfNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(listOfNumbers);

        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(new Person(3, "Dimon"));
        listOfPerson.add(new Person(1, "Oleg"));
        listOfPerson.add(new Person(2, "Nikita"));
        Collections.sort(listOfPerson, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() < o2.getId()) {
                    return 1;
                } else if (o1.getId() > o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(listOfPerson);
    }
}
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        /*
        * o1 > o2 = return 1;
        * o1 < o2 = return -1;
        * o1 == o2 = return 0;
        * compare(1, 2) = 1;
        * compare(2, 1) = -1;
        * compare(0, 0) = 0;
        */

        if (o1.length() == o2.length()) {
            return 0;
        } else if (o1.length() > o2.length()) {
            return 1;
        } else {
            return -1;
        }

    }
}

class IntegerSmallerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return 1;
        } else if (o1 > o2) {
            return -1;
        } else {
            return 0;
        }
    }
}
