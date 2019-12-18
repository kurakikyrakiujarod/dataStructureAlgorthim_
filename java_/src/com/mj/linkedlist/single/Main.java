package com.mj.linkedlist.single;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.remove(0);
//        list.clear();
        list.add(0, 100);
        System.out.println(list);
    }
}
