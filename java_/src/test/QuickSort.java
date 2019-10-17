package test;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = array[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && pivot <= array[high]) high--;
                array[low] = array[high];
                while (low < high && pivot >= array[low]) low++;
                array[high] = array[low];
            }
            array[low] = pivot;
            sort(array, start, low);
            sort(array, low + 1, end);
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 11, 22, 3, 4, 4, 3, 1, 2, 8, 9, 7, 6, 5, 0};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
