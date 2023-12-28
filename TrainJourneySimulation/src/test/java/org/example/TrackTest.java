package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    Station st1, st2, st3, st4, st5;
    Station st6 = new Station(6, 1.00f);
    Station st7 = new Station(7, 1.00f);
    Track track = new Track(st6, st7);

    @Test
    void testConstructor() {

        assertNotNull(track);
    }

    @Test
    void testCreateList() {
        Station[] stArray = {st1, st2, st3, st4, st5};

        //Track track;

        for (int i = 0; i < stArray.length; i++) {
            track.createTrack(stArray[i]);
        }

        assertNotNull(track);
    }
}