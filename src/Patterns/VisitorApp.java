package Patterns;

public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor hooligan = new HooliganVisitor();
        body.accept(hooligan);
        engine.accept(hooligan);
    }
}
// Посетитель
interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
}
// Автозапчасть
interface Element{
    void accept(Visitor visitor);
}
// Кузов
class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
// Двигатель
class BodyElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class HooliganVisitor implements Visitor{
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по корпусу");
    }
}
class MechanicVisitor implements Visitor {
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }
    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал двигатель");
    }
}














