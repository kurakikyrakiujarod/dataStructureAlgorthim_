package tree;

public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    public void frontShow(int index) {
        if (data == null || data.length < 1) return;
        System.out.println(data[index]);
        if (data.length > 2 * index + 1) {
            frontShow(2 * index + 1);
        }
        if (data.length > 2 * index + 2) {
            frontShow(2 * index + 2);
        }
    }
}
