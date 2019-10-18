package tree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1);
        binaryTree.setRoot(root);
        Node rootL = new Node(2);
        root.setLeftNode(rootL);
        //创建一个右节点
        Node rootR = new Node(3);
        //把新创建的节点设置为根节点的子节点
        root.setRightNode(rootR);

        //为第二层的左节点创建两个子节点
        rootL.setLeftNode(new Node(4));
        rootL.setRightNode(new Node(5));

        //为第二层的右节点创建两个子节点
        rootR.setLeftNode(new Node(6));
        rootR.setRightNode(new Node(7));

        //前序遍历树
        binaryTree.frontShow();
        System.out.println("===============");

        binaryTree.midShow();
        System.out.println("===============");

        binaryTree.afterShow();
        System.out.println("===============");
    }
}
