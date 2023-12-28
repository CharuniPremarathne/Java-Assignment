package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainJourneyTest {

    @Test
    void testConstructor(){
        TrainJourney trainJourney = new TrainJourney(1, 3);

        assertNotNull(trainJourney);
    }



}