package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
    public static void shellSort(int[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {

                    if (array[j] > array[j + gap]) swap(array, j, j + gap);
                }
            }

        }
    }*/

    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.length; i++) {

                int j = i;
                int temp = array[i];

                while (j - gap >= 0 && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                if (j != i) array[j] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = {18, 9, 1, 7, 2, 3, 5, 4, 6, 0, 10, 20, 11, 12};
        shellSort(array);
        System.out.println(Arrays.toString(array));

    }
}
