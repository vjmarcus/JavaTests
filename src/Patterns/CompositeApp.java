package Patterns;

import java.util.ArrayList;
import java.util.List;

/* Сумка в сумке. Сначала кладем фигуры в композит, потом композит с фигурами кладем в другой композит. Печатаем
общий композит и он выводит все фигуры из другого композита, который тоже лежит в главном композите
*/
public class CompositeApp {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape cube = new Cube();
        Shape oval = new Oval();
        Composite mainComposite = new Composite();
        Composite composite1 = new Composite();

        mainComposite.addComponent(rectangle);
        composite1.addComponent(cube);
        composite1.addComponent(oval);
        mainComposite.addComponent(composite1);
        mainComposite.draw();
    }

}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Привет, я квадрат");
    }
}

class Cube implements Shape {
    @Override
    public void draw() {
        System.out.println("Привет, я куб");
    }
}

class Oval implements Shape {
    @Override
    public void draw() {
        System.out.println("Привет, я овал");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }

    public void addComponent(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

}


