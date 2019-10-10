package algorithm;

import java.util.Arrays;
import java.util.Random;

public class DataChecker {

    static int[] generateRandomArray() {
        Random r = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10000);
        }
        return array;
    }

    static void check() {
        int[] array = generateRandomArray();
        int[] array2 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        Arrays.sort(array);
        InsertionSort.sort(array2);
        boolean isSame = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array2[i]) isSame = false;
            break;
        }
        System.out.println(isSame);
    }

    public static void main(String[] args) {
        check();

    }
}
