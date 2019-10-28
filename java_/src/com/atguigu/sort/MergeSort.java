package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }

    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) temp[t++] = array[i++];
            else temp[t++] = array[j++];
        }
        while (i <= mid) temp[t++] = array[i++];
        while (j <= right) temp[t++] = array[j++];

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) array[tempLeft++] = temp[t++];

    }

    public static void main(String[] args) {
        int[] array = {1, 0, 2, 3, 9, 8, 7, 4, 5, 6};
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));

    }
}
