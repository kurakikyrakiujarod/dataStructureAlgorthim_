package algorithm;

public class InsertionSort {
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void printArrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                {
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 0, 7, 5, 6, 4, 8, 9};
        sort(arr);
        printArrar(arr);

    }
}
