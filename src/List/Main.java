package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        measureTime(arrayList);
        measureTime(linkedList);
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
