package Patterns;

public class IteratorApp {
    public static void main(String[] args) {
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();
        Iterator iterator = concreteAggregate.getIterator();
        while (iterator.hasNext()){
            System.out.println((String) iterator.next());
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Aggregate {
    Iterator getIterator();
}
// Коллекция с массивом, который мы хотим перебирать
class ConcreteAggregate implements Aggregate {
    String[] tasks = {"Построить дом", "Родить сына", "Посадить дерево"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
