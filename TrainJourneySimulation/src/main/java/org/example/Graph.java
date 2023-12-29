package org.example;

public class Graph {

    private static boolean[] visited;

    public void graphTraversal(int[][] adjMatrix) {
        int startNode = 0;
        visited = new boolean[adjMatrix.length];
        System.out.println("Start node : " + startNode);
        depthFirstSearch(startNode, adjMatrix);
    }

    private void depthFirstSearch(int node, int[][] adjMatrix) {
        System.out.println(node);
        visited[node] = true;
        for (int i = 0; i < adjMatrix[node].length; i++) {
            if (adjMatrix[node][i] != 0 && !visited[i]) {
                depthFirstSearch(i, adjMatrix);
            }
        }
    }
}