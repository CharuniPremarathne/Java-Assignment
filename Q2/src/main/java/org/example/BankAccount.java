package org.example;

public class BankAccount {
    String accNumber;
    String accHolderName;
    float balance;
    String accType;

    public BankAccount(String accNumber, String accHolderName, float balance, String accType) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.balance = balance;
        this.accType = accType;
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

    public float getBalance() {
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
}
