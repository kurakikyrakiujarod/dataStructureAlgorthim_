package tree;

import java.util.Arrays;

public class HeapSort {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sort(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            maxHeap(array, i, 0);
        }
    }

    public static void maxHeap(int[] array, int heapSize, int index) {
        int leftNode = 2 * index + 1;
        int rightNode = leftNode + 1;
        int maxIndex = index;
        if (leftNode < heapSize && array[leftNode] > array[maxIndex]) maxIndex = leftNode;
        if (rightNode < heapSize && array[rightNode] > array[maxIndex]) maxIndex = rightNode;
        if (maxIndex != index) {
            swap(array, maxIndex, index);
            maxHeap(array, heapSize, maxIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 10, 2, 9, 3, 8, 4, 7, 5, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
