package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car1 = new Car("Toyota", "Camry", 2013, "red", 450000.00, 4, 4, true);
        Truck truck1 = new Truck("Ford", "F-150", 2012, "Blue", 650000.00, 6, 2000.00);

        int size = 2;

        Inventory inventory1 = new Inventory(size);

        inventory1.addVehicle(car1, 0);
        inventory1.addVehicle(truck1, 1);


        inventory1.getAveragePrice();

        logger.info("==== Search Vehicle ====");
        System.out.println("Enter the Make : ");
        String make = scanner.next();

        System.out.println("Enter the Model : ");
        String model = scanner.next();

        List<Vehicle> searchResults = inventory1.searchByMakeAndModel(make, model);

        System.out.println();

        logger.info("======== Searched Vehicles ========");
        for(Vehicle v : searchResults){
            System.out.println(v.getMake());
        }
    }
}