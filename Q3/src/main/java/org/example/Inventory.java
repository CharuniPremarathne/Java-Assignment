package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private Vehicle[] vehicles;

    private static final Logger logger = LoggerFactory.getLogger(Inventory.class);


    public Inventory(int size) {
        vehicles = new Vehicle[size];
    }

    Scanner scanner = new Scanner(System.in);

    //addVehicle to the inventory
//    public void addVehicle(Vehicle vehicle){
//        int index = 0;
//
//        System.out.print("Do you need to add a vehicle (y/n): ");
//        String response = scanner.nextLine();
//
//        while(response.equals("y")){
//            vehicles[index] = vehicle;
//
//            System.out.print("Do you need to add another vehicle (y/n): ");
//            response = scanner.nextLine();
//
//            index++;
//        }
//    }


    //add vehicle to the inventory
    public void addVehicle(Vehicle vehicle, int index) {
        vehicles[index] = vehicle;
    }

    //calculate the average price of a vehicle
    public double getAveragePrice() {
        double total = 0;
        int count = 0;
        double avg = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle != null) {
                total += vehicle.getPrice();
                count++;
            }
        }

        if (count > 0) {
            avg = total / count;
            System.out.println("The average price of a vehicle is : " + avg);
        } else {
            logger.warn("Incorrect count");
        }
        return avg;
    }

    //search the matching vehicles by make and model
    public List<Vehicle> searchByMakeAndModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>();

        int flag = 0;

        try {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                    matchingVehicles.add(vehicle);
                }else{
                    System.out.println("Make or Model is incorrect for : " + vehicle.getMake());
                }
            }
//            for (Vehicle v : vehicles) {
//                if (v.getMake().equals(make)) {
//                    flag++;
//
//                    if (v.getModel().equals(model)) {
//                        flag++;
//                    } else {
//                        System.out.println("Model is incorrect");
//                    }
//                } else {
//                    System.out.println("Make is incorrect");
//                }
//
//                if (flag == 2) {
//                    matchingVehicles.add(v);
//                }
//            }


        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return matchingVehicles;
    }
}
