package Patterns;

public class TemplateApp {
    public static void main(String[] args) {

        AclassTemplate aclassTemplate = new AclassTemplate();
        aclassTemplate.templateMethod();
    }
}
// Выделяем в абстрактный класс общую часть (строки 1, 3), вместо строки 2 делаем абстрактный класс differ (различающаяся часть)
abstract class Cclass{
    void templateMethod(){
        System.out.print("1");
        differ();
        System.out.print("3");
    }

    protected abstract void differ();
}
class Aclass{
    void method(){
        System.out.print("1");
        System.out.print("2");
        System.out.print("3");
    }
}
class Bclass{
    void method() {
        System.out.print("1");
        System.out.print("3");
        System.out.print("5");
    }
}
// Делаем правильный классы
class AclassTemplate extends Cclass{
    @Override
    protected void differ() {
        System.out.print("2");
    }
}
