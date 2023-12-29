package org.example;

import java.time.LocalTime;
import java.util.List;

//node for the circular linked list
public class Train implements Comparable<Train>{
    private int trainNo;
    private String trainType;

    private List<Station> stationList;
    public Train next;

    public Train(int trainNo, String trainType) {
        this.trainNo = trainNo;
        this.trainType = trainType;
    }

    public Train(int trainNo, String trainType,List<Station> stationList) {
        this.trainNo = trainNo;
        this.trainType = trainType;
        this.stationList = stationList;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public String getTrainType() {
        return trainType;
    }


    public List<Station> getStationList() {
        return stationList;
    }

    @Override
    public int compareTo(Train t) {
        return this.trainType.compareTo(t.trainType);
    }
}
