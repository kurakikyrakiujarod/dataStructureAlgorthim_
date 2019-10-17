package test;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= middle) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];

        for (int m = 0; m < temp.length; m++) {
            array[start + m] = temp[m];

        }

    }

    public static void main(String[] args) {
        int[] array = {0, 10, 1, 9, 2, 8, 3, 7, 4, 6, 5, 5};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
