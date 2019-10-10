package algorithm;

public class SelectionSort {

    static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);

        }
        return arr;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 8, 9, 0, 4, 5, 6, 11, 10, 13, 12};
        printArrar(arr);
        System.out.println();
        sort(arr);
        printArrar(arr);
    }

    static void printArrar(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
