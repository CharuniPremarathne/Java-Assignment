package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {

    //customer and bank account lists
    private Set<Customer> customerList;
    private Set<BankAccount> bankAccountList;

    public Bank() {
        this.customerList = new HashSet<>();
        this.bankAccountList = new HashSet<>();
    }

    //add customers
    public void addCustomer(String customerID, String customerName, String email, String phone){
        Customer customer = new Customer(customerID, customerName, email, phone);
        customerList.add(customer);
    }

    //remove customer
    public void removeCustomer(String email){
        Customer customer = findCustomer(email);
        customerList.remove(customer);
    }

    //add bank account
    public void addBankAccount(String accNumber, String accHolderName, double balance, String accType){
        BankAccount bankAccount = new BankAccount(accNumber, accHolderName, balance, accType);
        bankAccountList.add(bankAccount);
    }

    //remove bank account
    public void removeBankAccount(String accNumber){
        BankAccount account = findAccount(accNumber);
        bankAccountList.remove(account);
    }

    //return list of customer details
    public Set<Customer> getCustomerList(){
        return customerList;
    }

    //return list of bank account details
    public Set<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    //deposit money in the bank account
    public void deposit(String accNumber, double depositAmount){
        //find the account
        BankAccount account = findAccount(accNumber);

        //update the balance
        account.depositMoney(depositAmount);

        //display balance
        System.out.println ("Your current balance is  : " + account.getBalance());
    }

    //withdraw money in the bank account
    public void withdraw(String accNumber, double withdrawAmount){
        //find the account
        BankAccount account = findAccount(accNumber);

        //update the balance
        account.withdrawMoney(withdrawAmount);

        //display balance
        System.out.println ("Your current balance is  : " + account.getBalance());
    }

//    public void displayTransactions(String accNumber){
//        Transactions transactions = findAccount(accNumber);
//
//
//    }

    //find the account (deposit or withdrawal) by account number
    private BankAccount findAccount(String accNumber) {
        for(BankAccount account : bankAccountList){
            if(account.getAccNumber().equals(accNumber)){
                return account;
            }else{
                System.out.println("Account not found");
            }
        }
        return null;
    }

    private Customer findCustomer(String email){
        for(Customer customer : customerList){
            if(customer.getEmail().equals(email)){
                return customer;
            }else{
                System.out.println("Customer not found");
            }
        }
        return null;
    }
}
