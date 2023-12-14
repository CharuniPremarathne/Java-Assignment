package org.example;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String colour;
    private double price;

    public Vehicle(String make, String model, int year, String colour, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.price = price;
    }

    public Vehicle(){}

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
