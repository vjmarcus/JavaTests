package Patterns;

public class Prototype {
    public static void main(String[] args) {
        Human original = new Human(22, "Vasya");
        System.out.println(original);
        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human copy1 = factory.makeCopy();
        System.out.println(copy1);

        // Теперь меняем прототип человека, передаем другого
        factory.setPrototype(new Human(44, "Georgiy"));
        Human copyGeorgiy = factory.makeCopy();
        System.out.println(copyGeorgiy);
    }
}

// 1. Делаем интерфейс
interface Copyable {
    Object copy();
}

// 2. Создаем человека
class Human implements Copyable {
    int age;
    String name;
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human [age= " + age + ", name= " + name + "]";
    }
    // Делаем копию
    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }
}

// 3. Завод по копированию человеков
class HumanFactory {
    Human human;

    // Получаем в конструкторе экземпляр конкретного класса
    public HumanFactory(Human human) {
        this.human = human;
    }
    // Можно передать другого человека
    public void setPrototype(Human human) {
        this.human = human;
    }
    // Делаем копию
    Human makeCopy() {
        return (Human) human.copy();
    }
}
