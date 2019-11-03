package com.atguigu.tree;

import java.util.Arrays;

public class HeapSort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int heapSize, int index) {
        int maxIndex = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < heapSize && array[leftIndex] > array[maxIndex]) maxIndex = leftIndex;
        if (rightIndex < heapSize && array[rightIndex] > array[maxIndex]) maxIndex = rightIndex;
        if (maxIndex != index) {
            swap(array, maxIndex, index);
            heapify(array, heapSize, maxIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
