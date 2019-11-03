package com.atguigu.tree;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //测试
        //System.out.println("前序遍历"); // 1,2,3,5,4
        //binaryTree.preOrder();

        //System.out.println("中序遍历");
        //binaryTree.infixOrder(); // 2,1,5,3,4

        //System.out.println("后序遍历");
        //binaryTree.postOrder(); // 2,5,4,3,1
        //System.out.println(binaryTree.preOrderSearch(15));

        System.out.println("删除前,前序遍历");
        binaryTree.preOrder(); //  1,2,3,5,4
        binaryTree.delNode(5);
        //binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); // 1,2,3,4
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) this.root.preOrder();
        else System.out.println("二叉树为空，无法遍历");
    }

    public void infixOrder() {
        if (this.root != null) this.root.infixOrder();
        else System.out.println("二叉树为空，无法遍历");
    }

    public void postOrder() {
        if (this.root != null) this.root.postOrder();
        else System.out.println("二叉树为空，无法遍历");
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) return root.preOrderSearch(no);
        else return null;
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) return root.infixOrderSearch(no);
        else return null;
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) return root.postOrderSearch(no);
        else return null;
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) root = null;
            else root.delNode(no);
        } else System.out.println("空树，不能删除~");
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认null
    private HeroNode right; //默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder() {
        System.out.println(this); //先输出父结点
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();

    }

    public void infixOrder() {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    public void postOrder() {
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        if (this.no == no) return this;
        HeroNode resNode = null;
        if (this.left != null) resNode = this.left.preOrderSearch(no);
        if (resNode != null) return resNode;
        if (this.right != null) resNode = this.right.preOrderSearch(no);
        return resNode;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) resNode = this.left.infixOrderSearch(no);
        if (resNode != null) return resNode;
        if (this.no == no) return this;
        if (this.right != null) resNode = this.right.infixOrderSearch(no);
        return resNode;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) resNode = this.left.postOrderSearch(no);
        if (resNode != null) return resNode;
        if (this.right != null) resNode = this.right.postOrderSearch(no);
        if (resNode != null) return resNode;
        if (this.no == no) return this;
        return resNode;

    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) this.left.delNode(no);
        if (this.right != null) this.right.delNode(no);
    }

}