package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Track {

    public Station first = null;
    public Station last = null;

    private static final Logger logger = LoggerFactory.getLogger(Track.class);

    public Track() {
    }

    public void createTrack(Station station) {

        if (first == null) {
            first = station;
            last = station;
            first.previous = null;
            last.next = null;
        } else {
            last.next = station;
            station.previous = last;
            last = station;
            last.next = null;
        }
    }

    public List<Station> displayTrack() {
        List<Station> st = new ArrayList<>();
        Station current = first;

        if (first == null) {
            logger.info("The list is empty");
            return null;
        }
        while (current != null) {
            //System.out.print(current.getStationNo() + "\t");
            st.add(current);
            current = current.next;
        }
        return st;
    }
}

