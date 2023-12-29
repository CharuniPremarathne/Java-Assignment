package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void testConstructor(){
        Station station = new Station(1, 2.0f);

        assertEquals(1, station.getStationNo());
        assertEquals(2.0f, station.getDistance());
    }

    @Test
    void testTrainArrivals(){
        Train t1 = new Train(1, "longDis");
        Train t2 = new Train(2, "express");
        Train t3 = new Train(3, "shortDis");

        List<Train> trains = new ArrayList<>();

        trains.add(t1);
        trains.add(t2);
        trains.add(t3);

        Station st1 = new Station(1);
    }
}