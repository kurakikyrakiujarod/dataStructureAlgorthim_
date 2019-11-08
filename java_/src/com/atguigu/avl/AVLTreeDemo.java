package com.atguigu.avl;

public class AVLTreeDemo {

    public static void main(String[] args) {
        //int[] array = {4, 3, 6, 5, 7, 8};
        int[] array = { 10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            avlTree.add(new Node(array[i]));
        }
        System.out.println("树的高度=" + avlTree.getRoot().height());
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight());
    }
}

class AVLTree {
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

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void leftRotate() {

        //创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        newNode.right = right.left;
        //把当前结点的值替换成右子结点的值
        value = right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        left = newNode;

    }

    public int leftHeight() {
        if (left == null) return 0;
        return left.height();
    }

    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }


    public int rightHeight() {
        if (right == null) return 0;
        return right.height();
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
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
                leftRotate(); //左旋转..
            } else leftRotate();
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            } else rightRotate();
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