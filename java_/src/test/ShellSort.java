package test;

import java.util.Arrays;

public class ShellSort {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int d = array.length / 2; d > 0; d /= 2) {
            for (int i = d; i < array.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (array[j] > array[j + d]) {
                        swap(array, j, j + d);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
