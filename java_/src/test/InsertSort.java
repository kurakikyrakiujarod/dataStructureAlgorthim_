package test;

import java.util.Arrays;

public class InsertSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                int j;
                for (j = i - 1; j >= 0 && temp < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 10, 9, 8, 3, 4, 5, 7, 6};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
