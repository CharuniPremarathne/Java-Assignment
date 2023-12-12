package org.example;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String customerID;
    private String customerName;
    private String email;
    private String phone;

    //Bank account object
    private BankAccount bankAccount;

    public Customer(String customerID, String customerName, String email, String phone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.bankAccount = new BankAccount();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //set bankAccount with the customer
    public void setBankAccount(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
