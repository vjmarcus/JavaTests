package Patterns;

public class Test {
    public static void main(String[] args) {
        InitialValues initialValues = new InitialValues();
        initialValues.printValues();

    }
}
class InitialValues{
    boolean bool;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues initialValues;

    void printValues() {
        System.out.println("Data type    initial value");
        System.out.println("boolean     " + bool);
        System.out.println("char     " + c);
        System.out.println("byte     " + b);
        System.out.println("short     " + s);
        System.out.println("int      " + i);
        System.out.println("long     " + l);
        System.out.println("float      " + f);
        System.out.println("double      " + d);
        System.out.println("initialValues      " + initialValues);
    }
}
