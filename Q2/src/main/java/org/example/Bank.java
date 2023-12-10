package org.example;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    //customer and bank account sets
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
    public void removeCustomer(Customer customer){
        customerList.remove(customer);
    }

    //add bank account
    public void addBankAccount(String accNumber, String accHolderName, float balance, String accType){
        BankAccount bankAccount = new BankAccount(accNumber, accHolderName, balance, accType);
        bankAccountList.add(bankAccount);
    }

    //remove bank account
    public void removeBankAccount(BankAccount bankAccount){
        bankAccountList.remove(bankAccount);
    }

    //return list of customer details
    public Set<Customer> getCustomerList(){
        return customerList;
    }

    //return list of bank account details
    public Set<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
