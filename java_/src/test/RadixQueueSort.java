package test;

import java.util.Arrays;

public class RadixQueueSort {
    public static void sort(int[] array) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }

        int maxLength = (max + "").length();

        MyQueue[] temp = new MyQueue[10];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = new MyQueue();
        }

        for (int i = 0, division = 1; i < maxLength; i++, division *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = array[j] / division % 10;
                temp[num].add(array[j]);
            }
            int index = 0;

            for (int j = 0; j < temp.length; j++) {

                while (!temp[j].isEmpty()) {
                    array[index++] = temp[j].poll();
                }

            }

        }
    }

    public static void main(String[] args) {
        int[] array = {1, 11, 2, 22, 3, 33, 4, 555, 666, 77, 88, 99};
        sort(array);
        System.out.println(Arrays.toString(array));

    }
}
