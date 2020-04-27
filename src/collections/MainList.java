package collections;

import java.util.*;

public class MainList {
    public static void main(String[] args) {

        Set<Integer> setOfInteger = new HashSet<>();
        Set<Integer> setOfInteger2 = new HashSet<>();
        addValue(setOfInteger, 100);
        addValue(setOfInteger2, 150);

        // union
        Set<Integer> unionSet = new HashSet<>(setOfInteger);
        unionSet.addAll(setOfInteger2);
        System.out.println(unionSet);

        //retain
        Set <Integer> retainSet = new HashSet<>(setOfInteger2);
        retainSet.retainAll(setOfInteger);
        System.out.println(retainSet);

    }
    public static void addValue(Set<Integer> set, int size) {
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
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
