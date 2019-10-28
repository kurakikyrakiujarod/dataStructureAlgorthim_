package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] array) {

        int maxNum = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNum) maxNum = array[i];
        }

        int maxLength = ("" + maxNum).length();
        int[][] bucket = new int[10][array.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, factor = 1; i < maxLength; i++, factor *= 10) {
            for (int j = 0; j < array.length; j++) {
                int n = array[j] / factor % 10;
                bucket[n][bucketElementCounts[n]] = array[j];
                bucketElementCounts[n]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        array[index++] = bucket[k][j];
                    }
                    bucketElementCounts[k] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214, 1024};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }
}
