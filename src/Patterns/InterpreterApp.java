package Patterns;

public class InterpreterApp {
    public static void main(String[] args) {

        // 1 - 2 + 3
        Context context = new Context();
        Expression expression  = context.evaluate("1-2+3");
        System.out.println(expression.interpret());
    }
}
interface Expression {
    int interpret();
}
class NumberExpression implements Expression{
    int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
class MinusExpression implements Expression{

    Expression left;
    Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
class PlusExpression implements Expression{

    Expression left;
    Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
class Context{
    Expression evaluate(String string){
        int position = string.length() - 1; // Get last symbol of string
        while (position > 0) {
            if (Character.isDigit(string.charAt(position))){
                position--;
            } else {
                Expression left = evaluate(string.substring(0, position));
                Expression right = new NumberExpression(Integer.parseInt(string.substring(position + 1)));
                char operator = string.charAt(position);
                switch (operator){
                    case '-': return new MinusExpression(left, right);
                    case '+': return new PlusExpression(left, right);
                }
            }
        }
        int result = Integer.parseInt(string);
        return new NumberExpression(result);
    }
}