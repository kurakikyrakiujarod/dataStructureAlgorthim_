package com.atguigu.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            binarySortTree.add(new Node(array[i]));
        }
        binarySortTree.infixOrder();
        System.out.println("删除");
        binarySortTree.delNode(2);
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) root = node;
        else root.add(node);
    }

    public void infixOrder() {
        if (root != null) root.infixOrder();
        else System.out.println("二叉排序树为空，不能遍历");
    }

    public Node search(int value) {
        if (root == null) return null;
        else return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) return null;
        else return root.searchParent(value);
    }

    public void delNode(int value) {
        if (root == null) return;
        else {
            Node targetNode = search(value);
            if (targetNode == null) return;
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) parent.left = null;
                if (parent.right != null && parent.right.value == value) parent.right = null;
            } else if (targetNode.left != null && targetNode.right != null) {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) parent.left = targetNode.left;
                        else parent.right = targetNode.left;
                    } else root = targetNode.left;
                }
                if (targetNode.right != null) {
                    if (parent != null) {
                        if (parent.left.value == value) parent.left = targetNode.right;
                        if (parent.right.value == value) parent.right = targetNode.right;
                    } else root = targetNode.right;
                }
            }
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) target = target.left;
        delNode(target.value);
        return target.value;
    }
}


class Node {

    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) return;
        if (node.value < this.value) {
            if (this.left == null) this.left = node;
            else this.left.add(node);
        } else {
            if (this.right == null) this.right = node;
            else this.right.add(node);
        }
    }

    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    public Node search(int value) {
        if (value == this.value) return this;
        else if (value < this.value) {
            if (this.left == null) return null;
            else return this.left.search(value);
        } else {
            if (this.right == null) return null;
            else return this.right.search(value);
        }
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value))
            return this;
        else {
            if (value < this.value && this.left != null) return this.left.searchParent(value);
            else if (value >= this.value && this.right != null) return this.right.searchParent(value);
            else return null;
        }

    }


}