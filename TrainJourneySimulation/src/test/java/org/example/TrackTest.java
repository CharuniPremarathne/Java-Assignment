package org.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    private static final Logger logger = LoggerFactory.getLogger(TrackTest.class);

    Station st1 = new Station(1, 1.00f);
    Station st2 = new Station(2, 1.00f);
    Station st3 = new Station(3, 1.00f);
    Track track = new Track();

    @Test
    void testConstructor() {

        assertNotNull(track);
    }

    @Test
    void testCreateNewList() {

        track.createTrack(st1);

        assertEquals(st1, track.first);
        assertEquals(st1, track.last);
        assertNull(st1.previous);
        assertNull(st1.next);
    }

    @Test
    void testCreateList(){
        track.createTrack(st1);
        track.createTrack(st2);
        track.createTrack(st3);

        assertEquals(st2, st3.previous);
        assertEquals(st1, st2.previous);
        assertNull(st3.next);
        assertNull(st1.previous);
    }

    @Test
    void testDisplayTrackEmptyList(){
        Track t1 = new Track();

        assertEquals(null,t1.displayTrack());
    }

    @Test
    void testDisplayTrack(){
        track.createTrack(st1);
        track.createTrack(st2);
        track.createTrack(st3);

        assertEquals(3, track.displayTrack().size());
    }
}