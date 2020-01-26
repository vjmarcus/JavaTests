package Patterns;

public class DelegateApp {
    public static void main(String[] args) {

        // Создаем художника
        Painter painter = new Painter();
        // Передаем ему фигуру
        painter.setGraphics(new Triangle());
        // вызываем у фигуры метод draw, в зависимости от фигуры будет работать разный метод draw
        painter.draw();
        // Передаем другую фигуру, ну и т.д.
        painter.setGraphics(new Square());
        painter.draw();
    }
}
class A {
    void f(){
        System.out.println("f()");
    }
}

class B {
    A a = new A();
    void f() {
        a.f();
    }
}
// 1. Делаем интерфейс
interface Graphics{
    void draw();
}
// 2. Имплементируем интерфейс, реализуем метод
class Triangle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }
}
class Square implements Graphics {
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
class Circle implements Graphics {
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
// 3. Создаем художника, у которого делаем ссылку на интерфейс, и в методе вызываем метод интерфейса.
class Painter {
    Graphics graphics;
    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
    void draw(){
        graphics.draw();
    }
}