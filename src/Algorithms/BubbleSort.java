package Algorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array = new int [] {1, 21233, 24, 0, -123, 35, 46, 32};
        int first = sortAscending(array)[0];
        int last = sortAscending(array)[array.length - 1];
        System.out.println("First = " + first);
        System.out.println("Last = " + last);

        int descLast = sortDescending(array)[array.length - 1];
        System.out.println("DescLast = " + descLast);

        for (int num : array) {
            System.out.println(num);
        }
    }
    public static int [] sortAscending(int [] array) {
        for (int j = 0; j <= array.length - 1 ; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
    public static  int [] sortDescending(int [] array) {
        for(int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}

