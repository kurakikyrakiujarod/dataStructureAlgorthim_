package test;

import java.util.Arrays;

public class BubbleSort2 {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }

        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 99, 12, 77, 66, 8, 54, 2, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
