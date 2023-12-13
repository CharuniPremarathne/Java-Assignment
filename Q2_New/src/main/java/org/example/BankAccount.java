package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int accNumber;
    private String accHolderName;
    private double balance;
    private String accType;

    //transaction object
    List<Transactions> transactionList;

    //default constructor
    public BankAccount(){}
    public BankAccount(int accNumber, String accHolderName, double balance, String accType) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.balance = 0.0;
        this.accType = accType;
        this.transactionList = new ArrayList<>();
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
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
            addTransaction("124", LocalDate.now(), depositAmount, "deposit");
        }else{
            System.out.println("Invalid amount... Please try again..");
        }
    }

    //withdraw money
    public void withdrawMoney(double withdrawAmount){
        if (withdrawAmount > 0 && balance >= withdrawAmount){

            try{
                //update the balance
                balance -= withdrawAmount;

                //exception handling if balance < 0
                if(balance < 0){
                    throw new BalanceException(withdrawAmount);
                }else{
                    System.out.println("Successful..  Your withdrawal  : " + withdrawAmount + "/=");

                    //store the transaction details
                    addTransaction("123", LocalDate.now(), withdrawAmount, "withdraw");
                }
            }catch (BalanceException e){
                e.printStackTrace();
            }

        }else{
            System.out.println("Invalid amount... Please try again..");
        }
    }

    public void addTransaction(String transID, LocalDate transDate, double amount, String transType){
        Transactions transactions = new Transactions(transID, transDate, amount, transType);
        transactionList.add(transactions);
    }
    //read transactions
    public List<Transactions> getTransactionList(){
        return transactionList;
    }

}
