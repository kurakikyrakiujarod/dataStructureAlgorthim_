package test;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] array = {23, 6, 189, 45, 9, 287, 56, 1, 798, 34, 65, 652, 5};
        //System.out.println(Integer.MIN_VALUE);

        int[] counts = new int[10];
        counts[3]=array[0];
        counts[3]++;
        System.out.println(Arrays.toString(counts));


    }
}
