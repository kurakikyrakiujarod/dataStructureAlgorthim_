package algorithm;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 1, 2, 3, 0, 4, 6, 5, 7, 8, 8, 9};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));

    }

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));

//        for (int i = 0, j = 0; i < count.length; i++) {
//            while (count[i]-- > 0) result[j++] = i;
//        }
        for (int j = 1; j < count.length; j++) {
            count[j] = count[j] + count[j - 1];
        }
        System.out.println(Arrays.toString(count));

        for (int j = arr.length - 1; j >= 0; j--) {
            result[--count[arr[j]]] = arr[j];
        }

        return result;
    }
}
