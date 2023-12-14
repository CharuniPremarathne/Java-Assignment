package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void testCarClass() {
        Truck truck = new Truck("Toyota", "asd", 2012, "red", 450000, 40, 50);

        assertEquals("Toyota", truck.getMake());
        assertEquals("asd", truck.getModel());
        assertEquals(2012, truck.getYear());
        assertEquals("red", truck.getColour());
        assertEquals(450000, truck.getPrice());
        assertEquals(40, truck.getBedLength());
        assertEquals(50, truck.getPayLoadCapacity());
    }

    @Test
    void testSetters(){
        Truck truck = new Truck();

        truck.setMake("Toyota");
        truck.setModel("asd");
        truck.setYear(2012);
        truck.setColour("red");
        truck.setPrice(450000);
        truck.setBedLength(40);
        truck.setPayLoadCapacity(50);

        assertEquals("Toyota", truck.getMake());
        assertEquals("asd", truck.getModel());
        assertEquals(2012, truck.getYear());
        assertEquals("red", truck.getColour());
        assertEquals(450000, truck.getPrice());
        assertEquals(40, truck.getBedLength());
        assertEquals(50, truck.getPayLoadCapacity());

    }



}