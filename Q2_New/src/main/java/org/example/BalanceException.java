package org.example;

public class BalanceException  extends Exception{

    private double amount;

    BalanceException(double amount){
        this.amount = amount;
    }
}
