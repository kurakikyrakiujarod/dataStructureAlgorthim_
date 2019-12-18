package com.mj.test.singlelinkedlist;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList2<Integer> list = new SingleLinkedList2<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(list.indexOf(0));
        System.out.println(list.indexOf(1));
    }
}
