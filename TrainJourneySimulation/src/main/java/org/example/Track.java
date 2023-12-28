package org.example;

public class Track {

    public Station first = null;
    public Station last = null;

    public Track(Station first, Station last) {
        this.first = null;
        this.last = null;
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

    public void displayTrack() {

        Station current = first;

        if (first == null) {
            System.out.println("The list is empty");
        }
        while (current != null) {
            System.out.print(current.getStationNo() + "\t");
            current = current.next;
        }
    }
}

