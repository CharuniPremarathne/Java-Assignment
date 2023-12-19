package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    //customer and bank account lists
    private List<Customer> customerList;
    private List<BankAccount> bankAccountList;

    private static final Logger logger = LoggerFactory.getLogger(Bank.class);

    public Bank() {
        this.customerList = new ArrayList<>();
        this.bankAccountList = new ArrayList<>();
    }

    //add customers
    public void addCustomer(int customerID, String customerName, String email, String phone) {
        //create new customer
        Customer customer = new Customer(customerID, customerName, email, phone);
        customerList.add(customer);
    }

    //remove customer
    public void removeCustomer(String email) {
        Customer customer = findCustomer(email);
        customerList.remove(customer);
    }

    //add bank account
    public void addBankAccount(int accNumber, String accHolderName, double balance, String accType) {
        BankAccount bankAccount = new BankAccount(accNumber, accHolderName, balance, accType);
        bankAccountList.add(bankAccount);
    }

//    //add bank account
//    public void addBankAccount(BankAccount bankAccount){
//        bankAccountList.add(bankAccount);
//    }

    //remove bank account
    public void removeBankAccount(int accNumber) {
        BankAccount account = findAccount(accNumber);
        bankAccountList.remove(account);
        logger.info("Successfully Removed the account");
    }

    //return list of customer details
    public List<Customer> getCustomerList() {
        return customerList;
    }

    //return list of bank account details
    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    //deposit money in the bank account
    public void deposit(int accNumber, double depositAmount) {
        //find the account
        BankAccount account = findAccount(accNumber);

        //update the balance
        try {
            account.depositMoney(depositAmount);
        } catch (NullPointerException e) {
            logger.warn("Can't find Account");
        }
        //assert account != null;

        //display balance
        System.out.println("Your current balance is  : " + account.getBalance());
    }

    //withdraw money in the bank account
    public void withdraw(int accNumber, double withdrawAmount) {
        //find the account
        BankAccount account = findAccount(accNumber);

        //update the balance
        try {
            account.withdrawMoney(withdrawAmount);
        } catch (NullPointerException e) {
            logger.warn("Can't find Account");
        }

        //display balance
        logger.info("Your current balance is  : " + account.getBalance());
    }

    //find the account (deposit or withdrawal) by account number
    public BankAccount findAccount(int accNumber) {
        BankAccount acc = null;

        for (BankAccount account : bankAccountList) {
            if (account.getAccNumber() == accNumber) {
                acc = account;
                break;
            } else {
                try {
                    acc = null;
                } catch (Exception e) {
                    logger.warn("Account not found");
                }
            }
        }
        return acc;
    }

    //find the customer
    public Customer findCustomer(String email) {
        Customer cus = null;
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                cus = customer;
                break;
            } else {
                logger.warn("Customer not found");
                cus = null;
            }
        }
        return cus;
    }
}
