package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void testConstructor(){
        Station station = new Station(1, 2.0f);

        assertEquals(1, station.getStationNo());
        assertEquals(2.0f, station.getDistance());
    }
}