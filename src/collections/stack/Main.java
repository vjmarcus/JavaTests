package collections.stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Печем блины, кладем на тарелку, сверху берем последний испеченный блин
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.peek()); // показывает последний элемент сверху - 1
        System.out.println(stack.peek());
        System.out.println(stack.pop());  // берет последний элемент и удаляет его - 1 (остались 5, 3)
    }
}
