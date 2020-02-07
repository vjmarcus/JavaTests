package Patterns;

public class StrategyApp {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int [] array = new int[]{1, 231, 54, 47, 11};
        System.out.println(array[array.length - 1]);
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
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }

        }
    }
}

















