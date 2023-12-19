package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);


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
//    public void depositMoney(double depositAmount){
//        if (depositAmount > 0){
//            //update the balance
//            balance += depositAmount;
//            System.out.println("Successful..  You deposited  : " + depositAmount + "/=");
//
//            //store the transaction details
//            addTransaction("124", LocalDate.now(), depositAmount, "deposit");
//        }else{
//            System.out.println("Invalid amount... Please try again..");
//        }
//    }

    public double depositMoney(double depositAmount){

        if (depositAmount < 0) {
            try {
                throw new AmountException(depositAmount);
            } catch (AmountException e) {
                logger.error("Invalid amount... Please try again..");
                return 0;
            }
        }else{
            //update the balance
            balance += depositAmount;
            logger.info("Successful..  You deposited  : " + depositAmount + "/=");

            //store the transaction details
            addTransaction("124", LocalDate.now(), depositAmount, "deposit");
            return balance;
        }
    }

    //withdraw money
    public double withdrawMoney(double withdrawAmount){
        if (withdrawAmount > 0){

            try{
                //update the balance
                balance -= withdrawAmount;

                //exception handling if balance < 0
                if(balance < 0){
                    throw new AmountException(withdrawAmount);
                }else{
                    logger.info("Successful..  Your withdrawal  : " + withdrawAmount + "/=");

                    //store the transaction details
                    addTransaction("123", LocalDate.now(), withdrawAmount, "withdraw");
                }

            }catch (AmountException e){
                e.printStackTrace();
            }
            return balance;
        }else{
            logger.error("Invalid amount... Please try again..");
            return 0;
        }
    }

    public void addTransaction(String transID, LocalDate transDate, double amount, String transType){
        try{
            Transactions transactions = new Transactions(transID, transDate, amount, transType);
            transactionList.add(transactions);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    //read transactions
    public List<Transactions> getTransactionList(){
        return transactionList;
    }

}
