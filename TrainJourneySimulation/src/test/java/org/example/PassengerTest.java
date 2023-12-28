package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void testConstructor(){
        Passenger passenger = new Passenger(1,4);

        assertNotNull(passenger);
    }

    @Test
    void testCreateTrainJourney(){
        Passenger passenger = new Passenger(1,4);

        List<Station> track = new LinkedList<>();
        track.add(new Station(0, 1.0f));
        track.add(new Station(1, 2.0f));
        track.add(new Station(2, 3.0f));
        track.add(new Station(3, 4.0f));
        track.add(new Station(4, 5.0f));

        int adjMatrix[][] = {
                {0, 6, 0, 0, 11},
                {6, 0, 7, 0, 0},
                {0, 7, 0, 8, 10},
                {0, 0, 8, 0, 9},
                {11, 0, 10, 9, 0}
        };

        passenger.createTrainJourney(track, adjMatrix, 1,4);

        assertEquals(6,adjMatrix[0][1]);
    }

    @Test
    void testGetters(){
        Passenger p1 = new Passenger(0,3);

        assertEquals(0, p1.getStartSt());
        assertEquals(3, p1.getDestSt());
    }
}