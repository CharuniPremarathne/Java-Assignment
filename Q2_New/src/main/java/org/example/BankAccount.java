package org.example;

public class BankAccount {
    private String accNumber;
    private String accHolderName;
    private double balance;
    private String accType;

    //transaction object
    Transactions transactions;

    //default constructor
    public BankAccount(){}
    public BankAccount(String accNumber, String accHolderName, double balance, String accType) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.balance = 0.0;
        this.accType = accType;
        this.transactions = new Transactions();
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

    public void setBalance(double balance) {
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
            //update the balance
            balance += depositAmount;
            System.out.println("Successful..  You deposited  : " + depositAmount + "/=");

            //store the transaction details
            transactions.setTransactionAmount(depositAmount);
            transactions.setTransactionType("deposit");
        }else{
            System.out.println("Invalid amount... Please try again..");
        }
    }

    //withdraw money
    public void withdrawMoney(double withdrawAmount){
        if (withdrawAmount > 0 && balance >= withdrawAmount){
            //update the balance
            balance -= withdrawAmount;
            System.out.println("Successful..  Your withdrawed  : " + withdrawAmount + "/=");

            //store the transaction details
            transactions.setTransactionAmount(withdrawAmount);
            transactions.setTransactionType("withdraw");
        }else{
            System.out.println("Invalid amount... Please try again..");
        }
    }
}
