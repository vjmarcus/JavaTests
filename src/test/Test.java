package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {



    public static void main(String[] args) {
        List<String> colors = Arrays.asList("Красный", "Желтый", "Зеленый", "Голубой");
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            int rand = random.nextInt(colors.size());
            if (!stringList.contains(colors.get(rand))) {
                stringList.add(colors.get(rand));
            } else {
                i--;
            }
        }
        System.out.println(stringList);

    }
}
