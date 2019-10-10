package algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 9, 0, 1, 2, 2, 3, 10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int mid = partition(arr, leftBound, rightBound);
            sort(arr, leftBound, mid - 1);
            sort(arr, mid + 1, rightBound);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, rightBound);
        return left;
    }


}
