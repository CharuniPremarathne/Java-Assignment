package org.example;

import java.util.Date;

public class Transactions {
    private String transactionID;
    private Date transactionDate;
    private double transactionAmount;
    private String transactionType;

    public Transactions(String transactionID, Date transactionDate, double transactionAmount, String transactionType){
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
    }

    public void setTransactionID(String transactionID){
        this.transactionID = transactionID;
    }

    public String getTransactionID(){
        return transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
