package algorithm;

public class ShellSort {
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
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
        }


        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 0, 7, 5, 6, 4, 8, 9};
        printArrar(arr);
        System.out.println();
        sort(arr);
        printArrar(arr);

    }
}
