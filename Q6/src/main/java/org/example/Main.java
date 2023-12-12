package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //list of stations
        ArrayList<String> stationList = new ArrayList<>();
        stationList.add("Sta A");
        stationList.add("Sta B");
        stationList.add("Sta C");
        stationList.add("Sta D");
        stationList.add("Sta E");
        stationList.add("Sta F");
        stationList.add("Sta G");
        stationList.add("Sta H");
        stationList.add("Sta I");
        stationList.add("Sta J");
        stationList.add("Sta K");
        stationList.add("Sta L");

        System.out.println(stationList);

        /*
            take user inputs
            journey starting station
            destination station
         */
        System.out.println("Enter start station : ");
        String startStation = scanner.nextLine();

        System.out.println("Enter destination station : ");
        String destinationStation = scanner.nextLine();

        int startIndex = stationList.indexOf(startStation);
        int desIndex = stationList.indexOf(destinationStation);

        System.out.println("======================================");

        for(int i = startIndex; i <= desIndex; i++){
            System.out.println(stationList.get(i));
        }
    }
}