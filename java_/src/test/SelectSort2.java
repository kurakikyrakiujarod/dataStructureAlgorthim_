package test;

import java.util.Arrays;

public class SelectSort2 {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <array.length; j++) {
                if (array[minIndex] > array[j]) minIndex = j;

            }
            swap(array, minIndex, i);

        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 99, 12, 77, 66, 8, 54, 2, 10};
        sort(array);
        System.out.println(Arrays.toString(array));

    }
}
