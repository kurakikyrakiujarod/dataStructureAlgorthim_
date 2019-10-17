package test;

import java.util.Arrays;


public class BubbleSort {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    swap(array, begin, begin - 1);
                    sortedIndex = begin;
                }

            }
            end = sortedIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 12, 3, 14, 5, 16, 7, 9};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
