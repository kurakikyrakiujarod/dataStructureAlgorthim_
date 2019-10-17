package test;

import java.util.Arrays;

public class MergeSoft {
    static int[] leftArray;

    public static void soft(int[] array) {
        leftArray = new int[array.length >> 1];
        soft(array, 0, array.length);

    }

    private static void soft(int[] array, int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        soft(array, begin, mid);
        soft(array, mid, end);
        merge(array, begin, mid, end);
    }

    static void merge(int[] array, int begin, int mid, int end) {
        int li = 0;
        int le = mid - begin;
        int ri = mid;
        int re = end;
        int ai = begin;

        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        while (li < le) {
            if (ri < re && array[ri] < leftArray[li]) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 11, 2, 22, 3, 33, 44, 45, 46, 13, 14, 15, 15};
        soft(array);
        System.out.println(Arrays.toString(array));

    }
}
