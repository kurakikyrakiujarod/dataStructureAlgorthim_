package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目

    public static void main(String[] args) {
        int n = 5;  //结点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1);
        graph.showGraph();

    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }
}
