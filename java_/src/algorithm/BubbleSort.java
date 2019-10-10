package algorithm;

public class BubbleSort {
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

        boolean notChange = true;

        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    notChange = false;
                }

            }
            if (notChange) {
                //System.out.println(i);
                break;
            }


        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {11, 2, 3, 7, 8, 9, 0, 4, 5, 6};
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        printArrar(arr);
        System.out.println();
        sort(arr);
        printArrar(arr);


    }
}
