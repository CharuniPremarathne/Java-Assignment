package org.example;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Camry", 2013, "red", 450000.00, 4, 4, true);
        Truck truck1 = new Truck("Ford", "F-150", 2012, "Blue", 650000.00, 6, 2000.00);

        int size = 2;

        Inventory inventory1 = new Inventory(size);

        inventory1.addVehicle(car1, 0);
        inventory1.addVehicle(truck1, 1);


        inventory1.getAveragePrice();

        System.out.println("\n" + "Matching vehicles : " + inventory1.searchByMakeAndModel("Toyota", "Camry"));

    }
}