package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    int adjMatrix[][] = {
            {0, 6, 0, 0, 11},
            {6, 0, 7, 0, 0},
            {0, 7, 0, 8, 10},
            {0, 0, 8, 0, 9},
            {11, 0, 10, 9, 0}
    };

    @Test
    void testTraversal(){
        boolean[] expectedVisited = {true, true, true, true, true};

        Graph graph = new Graph();
        graph.visited = new boolean[adjMatrix.length];

        int startNode = 0;
        //graph.depthFirstSearch(startNode, adjMatrix);
        graph.graphTraversal(adjMatrix);
        graph.depthFirstSearch(startNode, adjMatrix);

        assertArrayEquals(expectedVisited, graph.visited);
    }

}