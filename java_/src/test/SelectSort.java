package test;

import java.util.Arrays;

public class SelectSort {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            swap(array, maxIndex, end);

        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 99, 12, 77, 66, 8, 54, 2, 10};
        sort(array);
        System.out.println(Arrays.toString(array));

    }
}
