package org.example;

import java.util.List;
import java.util.PriorityQueue;

public class Station {
    private int stationNo;
    private float distance;
    public List<Station> connectedStations;

    //linked list node attributes
    public Station previous;
    public Station next;



//    public Station(int stationNo, float distance, List<Station> connectedStations) {
//        this.stationNo = stationNo;
//        this.distance = distance;
//        this.connectedStations = connectedStations;
//    }

    public Station(int stationNo, float distance) {
        this.stationNo = stationNo;
        this.distance = distance;
    }

    public Station(int stationNo) {
        this.stationNo = stationNo;
    }

    public int getStationNo() {
        return stationNo;
    }

//    public void setStationNo(int stationNo) {
//        this.stationNo = stationNo;
//    }
//
//    public String getStationName() {
//        return stationName;
//    }
//
//    public void setStationName(String stationName) {
//        this.stationName = stationName;
//    }

    public float getDistance() {
        return distance;
    }

//    public void setDistance(float distance) {
//        this.distance = distance;
//    }

    public List<Station> getConnectedStations() {
        return connectedStations;
    }

//    public void setConnectedStations(List<Station> connectedStations) {
//        this.connectedStations = connectedStations;
//    }


    public void trainArrivals(List<Train> trains){
        PriorityQueue<Train> trainPriorityQueue = new PriorityQueue<>();

        //trainPriorityQueue.addAll(trainShedule.getTrains());
        trainPriorityQueue.addAll(trains);

        while(!trainPriorityQueue.isEmpty()){
            Train train = trainPriorityQueue.poll();
            System.out.print(train.getTrainNo() + "\t");
        }
    }
}