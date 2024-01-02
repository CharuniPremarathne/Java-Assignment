package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        boolean response = true;
//        //create new track
//        List<Track> trackList = new ArrayList<>();


        //Station List
        List<Station> stations = new ArrayList<>();
        stations.add(new Station(0, 1.0f));
        stations.add(new Station(1, 2.0f));
        stations.add(new Station(2, 3.0f));
        stations.add(new Station(3, 4.0f));
        stations.add(new Station(4, 5.0f));

        logger.info("Display Track");
        System.out.print("Start : ");

        int start = scanner.nextInt();

        System.out.print("Stop : ");
        int stop = scanner.nextInt();

        Track track = new Track();

        if (start < stop) {
            for (int i = start; i <= stop; i++) {
                track.createTrack(stations.get(i));
            }
        } else if (stop < start) {
            for (int i = start; i >= stop; i--) {
                track.createTrack(stations.get(i));
            }
        }

        //display track
        logger.info("Track : ");
        for (Station st : track.displayTrack()) {
            System.out.print(st.getStationNo() + "\t");
        }
        System.out.println("\n");


        int adjMatrix[][] = {
                {0, 6, 0, 0, 11},
                {6, 0, 7, 0, 0},
                {0, 7, 0, 8, 10},
                {0, 0, 8, 0, 9},
                {11, 0, 10, 9, 0}
        };


        logger.info("Traversal List");
        Graph newGraph = new Graph();
        newGraph.graphTraversal(adjMatrix);

        List<Station> stationList1 = new ArrayList<>();
        stationList1.add(0, stations.get(0));
        stationList1.add(1, stations.get(1));
        stationList1.add(2, stations.get(2));

        List<Station> stationList2 = new ArrayList<>();
        stationList2.add(0, stations.get(3));
        stationList2.add(1, stations.get(4));

        ///create train schedule
        TrainShedule trainShedule = new TrainShedule();
        trainShedule.addTrain(new Train(0, "longDis", stationList1));
        trainShedule.addTrain(new Train(1, "shortDis", stationList2));
        trainShedule.addTrain(new Train(2, "express", stationList1));
        trainShedule.addTrain(new Train(3, "longDis", stationList2));
        trainShedule.addTrain(new Train(4, "shortDis", stationList1));

        //display train schedule
        logger.info("\n\nTrain Schedule");

        for (Train t : trainShedule.getTrains()) {
            System.out.println(t.getTrainNo());
        }

        //map the list of trains associated with each station
        Map<Station, List<Train>> trainList = new HashMap<>();

        for (Train train : trainShedule.getTrains()) {
            for (Station station : train.getStationList()) {
                trainList.computeIfAbsent(station, k -> new ArrayList<>()).add(train);
            }
        }


        logger.info("\n\nArrival Priority");
        for (Map.Entry<Station, List<Train>> listEntry : trainList.entrySet()) {
            Station station = listEntry.getKey();
            List<Train> trains = listEntry.getValue();

            System.out.println("Station : " + station.getStationNo());
            station.trainArrivals(trains);

            System.out.println("\n");
        }

//        for (Station st : stations) {
//            st.trainArrivals(trains);
//        }


        logger.info("Create Passenger Queue");

        Queue queue = new Queue(50);

        List<Passenger> pssList = new ArrayList<>(queue.getMaxSize());

        boolean response = true;
        int startStation = 0;
        int desStation = 0;

        while (response) {
            //user input start and destination
            System.out.print("Enter the start station : ");
            startStation = scanner.nextInt();

            System.out.print("Enter the destination station : ");
            desStation = scanner.nextInt();

            pssList.add(new Passenger(startStation, desStation));

            System.out.println("Add another Passenger(Y/N) : ");
            String res = scanner.next();

            response = res.equalsIgnoreCase("Y") ? true : false;
        }

        //map for count the passengers in every stations
        HashMap<Integer, Integer> passengerCount = new HashMap<>();

        for (Passenger passenger : pssList) {
            passenger.createTrainJourney(stations, adjMatrix, passenger.getStartSt(), passenger.getDestSt());

            queue.insertPassenger(passenger);

            passengerCount.put(passenger.getDestSt(), passengerCount.getOrDefault(passenger.getDestSt(), 0) + 1);
        }

        //display queue
        logger.info("Passenger Queue");
        System.out.println(queue.peekFront());


        logger.info("\nPassenger Count");
        int pssCount = 0;
        //display the output
        for (int station : passengerCount.keySet()) {
            System.out.println("Station : " + station + " No. of passengers : " + passengerCount.get(station));

            for (Station st : stations) {
                if (station == st.getStationNo()) {
                    pssCount = queue.getnPassengers() - passengerCount.get(station);
                    System.out.println("Passenger Count for Station " + station + " --> " + pssCount);
                    queue.setnPassengers(pssCount);
                }
            }
        }
    }
}