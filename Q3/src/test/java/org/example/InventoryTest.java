package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void testAddVehicle() {
        Car car1 = new Car("Toyota", "Camry", 2013, "red", 450000.00, 4, 4, true);
        Truck truck1 = new Truck("Ford", "F-150", 2012, "Blue", 650000.00, 6, 2000.00);

        Inventory inventory1 = new Inventory(2);

        inventory1.addVehicle(car1, 0);
        inventory1.addVehicle(truck1, 1);

        assertNotNull(inventory1);

    }

    @Test
    void testGetAveragePrice() {
        Car car1 = new Car("Toyota", "Camry", 2013, "red", 450000.00, 4, 4, true);
        Truck truck1 = new Truck("Ford", "F-150", 2012, "Blue", 650000.00, 6, 2000.00);

        Inventory inventory1 = new Inventory(2);

        inventory1.addVehicle(car1, 0);
        inventory1.addVehicle(truck1, 1);

        inventory1.getAveragePrice();

        assertEquals(550000, inventory1.getAveragePrice());

    }

    @Test
    void testSearchByMakeAndModel() {
        Car car1 = new Car("Toyota", "Camry", 2013, "red", 450000.00, 4, 4, true);
        Truck truck1 = new Truck("Ford", "F-150", 2012, "Blue", 650000.00, 6, 2000.00);

        Vehicle[] vehicles = {car1, truck1};

        List<Vehicle>matchingVehs = new ArrayList<>();

        Inventory inventory1 = new Inventory(vehicles.length);

        matchingVehs = inventory1.searchByMakeAndModel("Toyota", "Carmy");

        for(Vehicle v:matchingVehs){
            assertEquals("Toyota", v.getMake());
        }

    }
}