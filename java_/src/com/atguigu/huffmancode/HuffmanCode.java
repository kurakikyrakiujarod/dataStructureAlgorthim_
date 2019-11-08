package com.atguigu.huffmancode;

import java.util.*;

public class HuffmanCode {

    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) counts.put(b, 1);
            else counts.put(b, count + 1);
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static void preOrder(Node root) {
        if (root != null) root.preOrder();
        else System.out.println("赫夫曼树为空");
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();

    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) return null;
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }

    }


    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        List<Node> nodes = getNodes(contentBytes);
        Node root = createHuffmanTree(nodes);
        //root.preOrder();
        getCodes(root);
        System.out.println(huffmanCodes);
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}