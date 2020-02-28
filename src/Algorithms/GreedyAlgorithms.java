package Algorithms;

import java.util.Arrays;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        int [] digits = {1, 3, 7, 9, 9, 5};
        String result = maxNumberFromDigits(digits);
        System.out.println(result);
    }
    public static String maxNumberFromDigits(int [] digits) {
        Arrays.sort(digits);
        String result = "";
        for (int i = digits.length - 1; i >= 0 ; i--) {
            result += digits[i];
        }
        return result;
    }
}