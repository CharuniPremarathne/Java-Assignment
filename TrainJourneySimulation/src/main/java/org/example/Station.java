package org.example;

import java.util.ArrayList;
import java.util.List;

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

    public float getDistance() {
        return distance;
    }

//
//    public void trainArrivals(List<Train> trains) {
//        PriorityQueue<Train> trainPriorityQueue = new PriorityQueue<>();
//
//        //trainPriorityQueue.addAll(trainShedule.getTrains());
//        try {
//            trainPriorityQueue.addAll(trains);
//        } catch (ClassCastException | NullPointerException | IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        while (!trainPriorityQueue.isEmpty()) {
//            Train train = trainPriorityQueue.poll();
//            System.out.print(train.getTrainNo() + "\t");
//        }
//    }

}
