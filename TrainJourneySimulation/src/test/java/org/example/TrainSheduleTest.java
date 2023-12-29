package org.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainSheduleTest {

    private static final Logger logger = LoggerFactory.getLogger(TrainSheduleTest.class);

    TrainShedule trainShedule = new TrainShedule();

    Train t1 = new Train(1, "express");
    Train t2 = new Train(2, "express");


    @Test
    void testCreateList(){

        trainShedule.addTrain(t1);
        trainShedule.addTrain(t2);

        assertEquals(t1, trainShedule.first);
        assertEquals(t2, trainShedule.last);
        assertEquals(t2, t1.next);
        assertEquals(t1, t2.next);

        assertEquals(2, trainShedule.getTrains().size());
    }

    @Test
    void testDisplayTrackEmptyList(){
        TrainShedule t1 = new TrainShedule();

        assertEquals(null,t1.getTrains());
    }



}