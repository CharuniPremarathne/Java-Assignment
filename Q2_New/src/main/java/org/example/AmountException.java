package org.example;

public class AmountException extends Exception {

    private double amount;

    public AmountException(double amount) {
        this.amount = amount;
    }
}
