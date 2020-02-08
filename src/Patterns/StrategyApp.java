package Patterns;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setStrategy(new BubbleSort());
        int [] array = {1234, 23, 24, -523, 535, 65};
        strategyClient.executeStrategy(array);
    }
}

//Strategy
interface Sorting {
    void sort(int[] array);
}

//Context
 class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }
}

class BubbleSort implements Sorting {
    @Override
    public void sort(int[] array) {
        System.out.println("Сортировка пузырьком");
        System.out.println("До " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("После сортировки пузырьком");
        System.out.println("После " + Arrays.toString(array));
    }
}

















