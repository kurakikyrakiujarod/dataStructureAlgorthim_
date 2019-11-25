package com.mj.dynamicarray;

public class Main {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(10);
        list.add(new Person(10, "Jack"));
        list.add(22);
        //list.clear();
        System.out.println(list);

    }
}
