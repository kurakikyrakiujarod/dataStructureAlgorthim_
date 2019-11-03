package com.atguigu.tree;

public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree {
    private int[] array;

    public ArrBinaryTree(int[] array) {
        this.array = array;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (array == null || array.length == 0) System.out.println("数组为空，不能按照二叉树的前序遍历");
        System.out.println(array[index]);
        if ((index * 2 + 1) < array.length) preOrder(2 * index + 1);
        if ((index * 2 + 2) < array.length) preOrder(2 * index + 2);
    }
}
