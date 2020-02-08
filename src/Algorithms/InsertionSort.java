package Algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(new int [] {23, 234, 532, -23, -234});
    }

    public void InsertionSort(int[] array) {
        System.out.println("Сортировка вставкой");
        System.out.println("До " + Arrays.toString(array));


        System.out.println("После сортировки вставкой");
        System.out.println("После " + Arrays.toString(array));
    }
}