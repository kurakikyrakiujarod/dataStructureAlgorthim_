package com.mj.binarysearchtree;

import com.mj.binarysearchtree.file.Files;
import com.mj.binarysearchtree.printer.BinaryTrees;
import com.mj.binarysearchtree.BinarySearchTree.Vistor;

import java.util.Comparator;

public class Main {
    private static class PersonComparator implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    private static class PersonComparator2 implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    static void test1() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
//        System.out.println(bst.height());
        //bst.preorderTraversal();
        //System.out.println(bst);
//        bst.levelOrder(new Vistor<Integer>() {
//            public void visit(Integer element) {
//                System.out.print("_" + element + "_ ");
//            }
//        });
    }

    static void test2() {
        Integer[] data = {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst1.add(new Person(data[i]));
        }

        BinaryTrees.println(bst1);

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }
        BinaryTrees.println(bst2);
    }

    static void test3() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int) (Math.random() * 100));
        }
//        String str = BinaryTrees.printString(bst);
//        Files.writeToFile("F:/1.txt", str);
        // BinaryTrees.println(bst);
    }

    static void test6() {
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        for (int i = 0; i < 20; i++) {
//            bst.add((int) (Math.random() * 100));
//        }
        Integer[] data = {7, 4, 9, 2, 5};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
        System.out.println(bst.height());
        System.out.println(bst.isComplete());
        //System.out.println(bst.height2());

    }


    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test6();
    }
}
