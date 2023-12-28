package org.example;

public class Edge {
    private int stationStart;
    private int stationEnd;
    private float distance;

    Edge(int stationStart, int stationEnd, float distance) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.distance = distance;
    }

    public int getStationStart() {
        return stationStart;
    }

    public int getStationEnd() {
        return stationEnd;
    }

    public float getDistance() {
        return distance;
    }
}
