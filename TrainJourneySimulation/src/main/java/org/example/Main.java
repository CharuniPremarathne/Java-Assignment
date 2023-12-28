package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Edge e1 = new Edge(0, 1, 6);
        Edge e2 = new Edge(0, 4, 12);
        Edge e3 = new Edge(1, 2, 7);
        Edge e4 = new Edge(1, 0, 6);
        Edge e5 = new Edge(2, 3, 9);
        Edge e6 = new Edge(2, 1, 7);
        Edge e7 = new Edge(2, 4, 8);
        Edge e8 = new Edge(3, 2, 9);
        Edge e9 = new Edge(3, 4, 10);
        Edge e10 = new Edge(4, 3, 10);
        Edge e11 = new Edge(4, 2, 8);
        Edge e12 = new Edge(4, 0, 12);

        List<Edge> edges = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);

        Graph newGraph = new Graph();

        newGraph.createGraph(edges);

        newGraph.printStationList(newGraph);

        Scanner scanner = new Scanner(System.in);

        //Station List
        List<Station> stations = new ArrayList<>();
        stations.add(new Station(0, 1.0f));
        stations.add(new Station(1, 2.0f));
        stations.add(new Station(2, 3.0f));
        stations.add(new Station(3, 4.0f));
        stations.add(new Station(4, 5.0f));

        try {
            for (Station st : stations) {
                System.out.print("Station : " + st.getStationNo() + " --> ");
                List<Station> st1 = newGraph.stationList.get(st.getStationNo());

                for (Station stCon : st1) {
                    System.out.print(stCon.getStationNo() + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        boolean response = true;
//        //create new track
//        List<Track> trackList = new ArrayList<>();


        System.out.println("Display Track");
        System.out.print("Start : ");
        int start = scanner.nextInt();

        System.out.print("Stop : ");
        int stop = scanner.nextInt();

        Track track = new Track(new Station(start), new Station(stop));

        if (start < stop) {
            for (int i = start; i <= stop; i++) {
                track.createTrack(stations.get(i));
            }
        } else if (stop < start) {
            for (int i = stop; i >= start; i--) {
                track.createTrack(stations.get(i));
            }
        }

        //display track
        System.out.print("Track : ");
        track.displayTrack();


        int adjMatrix[][] = {
                {0, 6, 0, 0, 11},
                {6, 0, 7, 0, 0},
                {0, 7, 0, 8, 10},
                {0, 0, 8, 0, 9},
                {11, 0, 10, 9, 0}
        };

//        //user input start and destination
//        System.out.print("Enter the start station : ");
//        int startStation = scanner.nextInt();
//
//        System.out.print("Enter the destination station : ");
//        int desStation = scanner.nextInt();
//
//        Passenger p1 = new Passenger(startStation, desStation);
//        p1.createTrainJourney(stations, adjMatrix, startStation, desStation);

        List<Station> stationList1 = new ArrayList<>();
        stationList1.add(0, stations.get(0));
        stationList1.add(1, stations.get(1));
        stationList1.add(2, stations.get(2));

        List<Station> stationList2 = new ArrayList<>();
        stationList2.add(0, stations.get(3));
        stationList2.add(1, stations.get(4));

        ///create train schedule
        TrainShedule trainShedule = new TrainShedule();
        trainShedule.addTrain(new Train(0, "longDis", 01.00f, stationList1));
        trainShedule.addTrain(new Train(1, "shortDis", 02.00f, stationList2));
        trainShedule.addTrain(new Train(2, "express", 03.00f, stationList1));
        trainShedule.addTrain(new Train(3, "longDis", 04.00f, stationList2));
        trainShedule.addTrain(new Train(4, "shortDis", 05.00f, stationList1));

        //display train schedule
        System.out.println("\n\nTrain Schedule");
        trainShedule.displayTrains();

        Map<Station, List<Train>> trainList = new HashMap<>();

        try {
            for (Train train : trainShedule.getTrains()) {
                for (Station station : train.getStationList()) {
                    trainList.computeIfAbsent(station, k -> new ArrayList<>()).add(train);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\n\nArrival Priority");
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


        System.out.println("Create Passenger Queue");

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

            if (res.equalsIgnoreCase("Y")) {
                response = true;
            } else {
                response = false;
            }
        }

        //map for count the passengers in every stations
        HashMap<Integer, Integer> passengerCount = new HashMap<>();

        for (Passenger passenger : pssList) {
            passenger.createTrainJourney(stations, adjMatrix, passenger.getStartSt(), passenger.getDestSt());

            queue.insertPassenger(passenger);

            passengerCount.put(passenger.getDestSt(), passengerCount.getOrDefault(passenger.getDestSt(), 0) + 1);
        }

        //display queue
        System.out.println("Passenger Queue");
        System.out.println(queue.peekFront());


        System.out.println("\nPassenger Count");
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