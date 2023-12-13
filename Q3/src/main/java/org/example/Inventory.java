package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private Vehicle[] vehicles;

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
            System.out.println("Incorrect count");
        }
        return avg;

    }

    //search the matching vehicles by make and model
    public List<Vehicle> searchByMakeAndModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>();

        try{
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                    matchingVehicles.add(vehicle);
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }


        System.out.print(Arrays.toString(matchingVehicles.toArray(new Vehicle[0])));
        //System.out.print(matchingVehicles.toArray(new Vehicle[0]));
        return matchingVehicles;
    }
}
