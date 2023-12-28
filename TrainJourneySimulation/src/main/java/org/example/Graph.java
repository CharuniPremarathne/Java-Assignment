package org.example;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Station>> stationList = new ArrayList<>();

    public void createGraph(List<Edge> edges) {
        int n = 0;

        for (Edge e : edges) {
            n = Integer.max(n, Integer.max(e.getStationStart(), e.getStationEnd()));
        }

        for (int i = 0; i <= n; i++) {
            stationList.add(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            stationList.get(e.getStationStart()).add(new Station(e.getStationEnd(), e.getDistance()));
        }
    }

    public void printStationList(Graph graph) {
        int start = 0;
        int n = graph.stationList.size();

        System.out.println("Adjacency List of stations");
        while (start < n) {
            for (Station st : graph.stationList.get(start)) {
                System.out.println(start + " ------> " + st.getStationNo() + " Distance : " + st.getDistance());
            }
            start++;
        }
    }

    public void setStationList(List<List<Station>> stationList) {
        this.stationList = stationList;

    }
}