package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrainJourney {

    private int startSt;
    private int stopSt;

    private static final Logger logger = LoggerFactory.getLogger(TrainJourney.class);

    public TrainJourney(int startSt, int stopSt) {
        this.startSt = startSt;
        this.stopSt = stopSt;
    }

    public void searchDistance(List<Station> stations, int[][] adjMatrix, int startSt, int destSt) {
        //distance of vertexes
        int[] vertexDisArray = new int[stations.size()];
        //store count of visited vertices
        boolean[] visited = new boolean[stations.size()];
        int[] shortestPath = new int[stations.size()];

        //startSt = 0;


        //startSt vertex distance = 0
        vertexDisArray[startSt] = 0;

        for (int i = 0; i < stations.size(); i++) {
            vertexDisArray[i] = i == startSt ? 0:Integer.MAX_VALUE;
            visited[i] = false;
            shortestPath[i] = -1;
        }

        //list of all possible paths
        ArrayList<LinkedList<Station>> allPaths = new ArrayList<>();

        //finding most close vertex
        for (int i = 0; i < stations.size(); i++) {
            int minDisVertex = findMinDisVertex(vertexDisArray, visited);

            //marking the vertex that is most close to startSt/current
            visited[minDisVertex] = true;

            //find the shortest shortestPath
            for (int j = 0; j < stations.size(); j++) {
                if (adjMatrix[minDisVertex][j] != 0 && !visited[j]) {
                    int newDist = vertexDisArray[minDisVertex] + adjMatrix[minDisVertex][j];
                    if (newDist < vertexDisArray[j]) {
                        vertexDisArray[j] = newDist;
                        shortestPath[j] = minDisVertex;
                    }
                }
            }
        }

        //find all paths
//        LinkedList<Station> currentPath = new LinkedList<>();
//        currentPath.add(stations.get(destSt));
//        findAllPaths(stations, shortestPath, destSt, currentPath, allPaths);

        //display all paths
//        System.out.println("All Paths from : " + startSt);
//
//        for(LinkedList<Station> path : allPaths){
//            for(Station station:path){
//                System.out.print(station.getStationNo() + " , ");
//            }
//            System.out.print("\n");
//        }

        //display shortest path
        logger.info("Shortest Path : ");
        printPath(shortestPath, destSt);
        logger.info("\nDistance : " + vertexDisArray[destSt]);

        //return vertexDisArray[destSt];
    }

//    private void findAllPaths(List<Station> stations, int[] shortestPath, int currentVertex,LinkedList<Station> currentPath, ArrayList<LinkedList<Station>> allPaths) {
//        if(shortestPath[currentVertex] != -1){
//            currentPath.addFirst(stations.get(shortestPath[currentVertex]));
//            findAllPaths(stations, shortestPath, shortestPath[currentVertex], currentPath, allPaths);
//            currentPath.removeFirst();
//        }else{
//            allPaths.add(new LinkedList<>(currentPath));
//        }
//    }

    private void printPath(int[] path, int destSt) {
        if (path[destSt] != -1) {
            printPath(path, path[destSt]);
            System.out.print(" , ");
        }
        System.out.print(destSt);
    }

    private static int findMinDisVertex(int[] vertexDisArray, boolean[] visited) {
        int minVertex = -1;

        for (int i = 0; i < vertexDisArray.length; i++) {
            if (visited[i] == false && (minVertex == -1 || vertexDisArray[i] < vertexDisArray[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;

    }
}
