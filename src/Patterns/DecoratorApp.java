package Patterns;

public class DecoratorApp {
    public static void main(String[] args) {
//        PrintInterface printer = new Printer("Я принтер");
        PrintInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Я принтер"))));
                printer.print();
        System.out.println("");
                Decorator printer1 = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Я принтер"))));
                printer1.print();
    }
}

interface PrintInterface {
    void print();
}

class Printer implements PrintInterface {

    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrintInterface {
    PrintInterface component;

    public Decorator(PrintInterface component) {
        this.component = component;
    }
    public void print(){
        component.print();
    }
}

// Внешняя оболочка над нашим принтером
class QuotesDecorator extends Decorator {

    public QuotesDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

// Еще один декоратор
class LeftBracketDecorator extends Decorator {

    public LeftBracketDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}

// И еще один декоратор
class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}