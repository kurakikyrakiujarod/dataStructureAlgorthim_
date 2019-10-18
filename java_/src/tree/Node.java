package tree;

public class Node {
    int value;
    Node leftNode;
    Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void frontShow() {
        System.out.println(value);
        if (leftNode != null) leftNode.frontShow();
        if (rightNode != null) rightNode.frontShow();
    }

    public void midShow() {
        if (leftNode != null) leftNode.midShow();
        System.out.println(value);
        if (rightNode != null) rightNode.midShow();

    }

    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.println(value);
    }
}
