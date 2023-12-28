package org.example;

import java.time.LocalTime;
import java.util.List;

//node for the circular linked list
public class Train implements Comparable<Train>{
    private int trainNo;
    private String trainType;
    private float time;

    private List<Station> stationList;
    public Train next;
    int priority;

    public Train(int trainNo, String trainType, float time) {
        this.trainNo = trainNo;
        this.trainType = trainType;
        this.time = time;
    }

    public Train(int trainNo, String trainType, float time, List<Station> stationList) {
        this.trainNo = trainNo;
        this.trainType = trainType;
        this.time = time;
        this.stationList = stationList;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public String getTrainType() {
        return trainType;
    }

    public float getTime() {
        return time;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    @Override
    public int compareTo(Train t) {
        return this.trainType.compareTo(t.trainType);
    }
}
