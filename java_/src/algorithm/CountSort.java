package algorithm;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 0, j = 0; i < count.length; i++) {
            while (count[i]-- > 0) result[j++] = i;
        }
        return result;
    }
}