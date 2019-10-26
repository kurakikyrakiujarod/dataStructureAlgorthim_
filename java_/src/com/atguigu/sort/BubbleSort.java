package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void bubbleSort(int[] array) {

        int temp = 0;
        boolean flag = false;

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if (!flag) break;
            else flag = false;
        }

    }

    public static void main(String[] args) {

        int[] array = new int[80000];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }

        //System.out.println("排序前数组 " + Arrays.toString(array));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间是 " + simpleDateFormat.format(date1));

        bubbleSort(array);

        //System.out.println("排序后数组 " + Arrays.toString(array));
        Date date2 = new Date();
        System.out.println("排序后的时间是 " + simpleDateFormat.format(date2));


    }
}
