package com.atguigu.sort;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] array) {

        int insertValue;
        int insertIndex;

        for (int i = 1; i < array.length; i++) {

            insertValue = array[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && array[insertIndex] > insertValue) {

                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;

            }

            if (insertIndex + 1 != i) array[insertIndex + 1] = insertValue;

        }

    }

    public static void main(String[] args) {

        int[] array = new int[12];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }

        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
