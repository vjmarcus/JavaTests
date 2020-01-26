package Algorithms;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 100;
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
    }

    private static long fibNaiveWithMem(int n, long[] mem) {
        if (mem[n] != -1) {
            return mem[n];
        } else if (n <= 1) {
            return n;
        }
        long result = fibNaiveWithMem(n - 1, mem) + fibNaiveWithMem(n - 2, mem);
        mem[n] = result;
        return result;
    }

    private static long fibNaive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibNaive(n - 1) + fibNaive(n - 2);
        }
    }

    // Наивный медленный алгоритм
    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
