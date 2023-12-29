package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void testConstructor(){
        List<Station> stationList1 = new ArrayList<>();
        stationList1.add(0, new Station(1));
        stationList1.add(1, new Station(2));
        stationList1.add(2, new Station(3));

        Train train = new Train(1, "express", stationList1);

        assertEquals(1, train.getTrainNo());
        assertEquals("express", train.getTrainType());
        assertEquals(stationList1, train.getStationList());
    }

    @Test
    void testCompareTo(){

        Train train = new Train(1, "express");

        assertEquals(0,train.compareTo(train));
    }
}