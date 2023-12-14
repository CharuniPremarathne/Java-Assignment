package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accNumber;
    private String accHolderName;
    private double balance;
    private String accType;

    //transactions List
    private List<Transactions> transactionsList;

    public BankAccount(String accNumber, String accHolderName, double balance, String accType) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.balance = balance;
        this.accType = accType;
        this.transactionsList = new ArrayList<>();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    //deposit money
    public void depositMoney(double depositAmount){
        if (depositAmount > 0){
            balance += depositAmount;
            System.out.println("Successful..  New Balance is  : " + balance + "/=");
        }else{
            System.out.println("Invalid amount... Please try again..");
        }
    }

    //withdraw money
    public void withdrawMoney(double withdrawAmount){
        if (withdrawAmount > 0 && balance >= withdrawAmount){
            balance -= withdrawAmount;
            System.out.println("Successful..  New Balance is  : " + balance + "/=");
        }else{
            System.out.println("Invalid amount... Please try again..");
        }
    }

    //get transaction history
    public void getTransactionHistory(Transactions transaction){
        transactionsList.add(transaction);
    }
}
