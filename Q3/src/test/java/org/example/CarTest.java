package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarClass() {
        Car car = new Car("Toyota", "asd", 2012, "red", 450000, 4, 5, true);

        assertEquals("Toyota", car.getMake());
        assertEquals("asd", car.getModel());
        assertEquals(2012, car.getYear());
        assertEquals("red", car.getColour());
        assertEquals(450000, car.getPrice());
        assertEquals(4, car.getNumDoors());
        assertEquals(5, car.getNumPassengers());
        assertEquals(true, car.isConvertible());

    }

    @Test
    void testSetters(){
        Car car = new Car();

        car.setMake("Toyota");
        car.setModel("asd");
        car.setYear(2012);
        car.setColour("red");
        car.setPrice(450000);
        car.setNumDoors(4);
        car.setNumPassengers(5);
        car.setConvertible(true);

        assertEquals("Toyota", car.getMake());
        assertEquals("asd", car.getModel());
        assertEquals(2012, car.getYear());
        assertEquals("red", car.getColour());
        assertEquals(450000, car.getPrice());
        assertEquals(4, car.getNumDoors());
        assertEquals(5, car.getNumPassengers());
        assertEquals(true, car.isConvertible());

    }

}