package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static List<Integer> binarySearch(int[] array, int left, int right, int findVal) {

        if (left > right) return new ArrayList<>();

        int mid = (left + right) / 2;
        //int mid = left + (right - left) * (findVal - array[left]) / (array[right] - array[left]);
        int midVal = array[mid];

        if (midVal < findVal) return binarySearch(array, mid + 1, right, findVal);
        else if (midVal > findVal) return binarySearch(array, left, mid - 1, findVal);
        else {
            List<Integer> resIndexlist = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || array[temp] != findVal) break;
                resIndexlist.add(temp);
                temp--;
            }

            temp = mid + 1;
            while (true) {
                if (temp > array.length - 1 || array[temp] != findVal) break;
                resIndexlist.add(temp);
                temp++;
            }
            resIndexlist.add(mid);
            return resIndexlist;
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 10, 11, 14, 14, 14, 14, 14, 17, 18, 19, 20};
        List<Integer> resIndexList = binarySearch(array, 0, array.length - 1, 14);
        System.out.println("resIndexList=" + resIndexList);

    }
}
