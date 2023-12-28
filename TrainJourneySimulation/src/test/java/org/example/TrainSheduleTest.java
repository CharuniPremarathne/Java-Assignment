package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainSheduleTest {

    TrainShedule trainShedule = new TrainShedule();

    Train t1 = new Train(1, "express", 01.00f);
    Train t2 = new Train(2, "express", 01.00f);


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

//    @Test
//    void testListIsNull(){
//        TrainShedule trainShedule1 = new TrainShedule();
//
//        assertEquals(-99, trainShedule.displayTrains());
//    }
//
//    @Test
//    void testListIsNotNull(){
//        assertEquals(2, trainShedule.displayTrains());
//    }

}