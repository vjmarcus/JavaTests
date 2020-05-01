package comparable;
import java.util.*;

/* Нужно сортировать обьекты в коллекции. Для этого у нашего обьекта имплементируем интерфейс Comparable и описываем
* метод compareTo - в нем описываем, как сортировать наши классы (1, -1, 0)
* */
public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Set<Person> personSet = new TreeSet<>();

        addElements(personList);
        addElements(personSet);

        System.out.println(personList);
        Collections.sort(personList);

        System.out.println(personList);
        System.out.println(personSet);

    }


    private static void addElements(Collection collection) {
        collection.add(new Person(4, "Landerius"));
        collection.add(new Person(1, "Bob"));
        collection.add(new Person(2, "Jake"));
        collection.add(new Person(3, "Emily"));
    }
}

class Person implements Comparable<Person> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
