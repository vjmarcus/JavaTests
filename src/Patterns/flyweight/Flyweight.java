package Patterns.flyweight;

import java.util.*;

public class Flyweight {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));

        Random random = new Random();
        for (Shape shape: shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
        }
    }
}

// Shape
interface Shape {
    void draw(int x, int y);
}
// Point flyweight
class Point implements Shape {
    @Override
    public void draw(int x, int y) {
        System.out.println("Рисуем точку");
    }
}
// Circle flyweight
class Circle implements Shape {

    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("Рисуем круг радиусом "+ r);
    }
}
// Square flyweight
class Square implements Shape {

    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("Рисуем квадрат со стороной " + a);
    }
}
class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName){
                case "круг":
                    shape = new Circle();
                    break;
                case "квадрат":
                    shape = new Square();
                    break;
                case "точка":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}