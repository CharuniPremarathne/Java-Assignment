package org.example;

public class Truck extends Vehicle{
    private int bedLength;
    private double payLoadCapacity;

    public Truck(){}
    public Truck(String make, String model, int year, String colour, double price, int bedLength, double payLoadCapacity) {
        super(make, model, year, colour, price);
        this.bedLength = bedLength;
        this.payLoadCapacity = payLoadCapacity;
    }

    public int getBedLength() {
        return bedLength;
    }

    public void setBedLength(int bedLength) {
        this.bedLength = bedLength;
    }

    public double getPayLoadCapacity() {
        return payLoadCapacity;
    }

    public void setPayLoadCapacity(double payLoadCapacity) {
        this.payLoadCapacity = payLoadCapacity;
    }
}
