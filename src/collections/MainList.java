package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainList {
    public static void main(String[] args) {

        // Test myLinkedList (simple linked list)
        MyLinkedList myLinkedList  = new MyLinkedList();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);





    }
    public static void measureTime(List <Integer> list) {
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int x = list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
