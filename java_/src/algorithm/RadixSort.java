package algorithm;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {421, 240, 115, 532, 305, 430, 124};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));

    }

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < 3; i++) {
            int division = (int) Math.pow(10, i);
            System.out.println("division " + division);

            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / division % 10;
                System.out.print(num + " ");
                count[num]++;
            }

            System.out.println();
            System.out.println(Arrays.toString(count));

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }
            System.out.println(Arrays.toString(count));
            for (int k = arr.length - 1; k >= 0; k--) {
                int num = arr[k] / division % 10;
                result[--count[num]] = arr[k];
            }
            System.arraycopy(result,0,arr,0,arr.length);
            Arrays.fill(count, 0);

        }

        return result;
    }

}
