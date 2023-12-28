package org.example;

import java.util.List;

public class Passenger {
    private int startSt;
    private int destSt;

    public Passenger(int startSt, int destSt) {
        this.startSt = startSt;
        this.destSt = destSt;
    }

    public void createTrainJourney(List<Station> stations, int[][] adjMatrix, int startSt, int destSt) {
        TrainJourney trainJourney = new TrainJourney(startSt, destSt);
        trainJourney.searchDistance(stations, adjMatrix, startSt, destSt);
    }

//
//    public void passengerBoarding() {
//
//    }


    public int getStartSt() {
        return startSt;
    }

    public int getDestSt() {
        return destSt;
    }
}
