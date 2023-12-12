package org.example;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //creating the bank instance
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        /*
              Input customer details
         */

        System.out.println("====== Customer Details ======");

        //customer name
        System.out.print("Enter your name : ");
        String customerName = scanner.nextLine();

        //email
        System.out.print("Enter your email : ");
        String email = scanner.nextLine();

        //contact number
        System.out.print("Enter your contactNumber : ");
        String phone = scanner.nextLine();

        bank.addCustomer("12345", customerName, email, phone);


        //retrieve customer and bank accounts lists of object "bank"
        Set<Customer> customersList = bank.getCustomerList();

        for(Customer customer : customersList){

            /*
                set the customer's bank account details
             */

            customer.getBankAccount().setAccNumber("1234");

            //set account holder name to the customer name
            customer.getBankAccount().setAccHolderName(customerName);

            //input account type
            System.out.print("Enter the Account Type : ");
            String accType = scanner.nextLine();
            customer.getBankAccount().setAccType(accType);

            String accNum = customer.getBankAccount().getAccNumber();
            String holderName = customer.getBankAccount().getAccHolderName();
            String accountType = customer.getBankAccount().getAccType();
            Double balance = customer.getBankAccount().getBalance();


            //print details
            System.out.println();
            System.out.println("===== Customer Details =====");
            System.out.println("Name : " + customer.getCustomerName());
            System.out.println("Email : " + customer.getEmail() + " ");
            System.out.println("Contact : " + customer.getPhone());

            System.out.println();
            System.out.println("===== Bank Account Details =====");
            System.out.println("Account Holders Number : " + accNum);
            System.out.println("Account Holders Name : " + holderName);
            System.out.println("Balance : " + balance);
            System.out.println("Account Type : " + accountType);

            bank.addBankAccount(accNum, holderName, balance, accountType);
            ///bank.addBankAccount(((customer.getBankAccount().setAccNumber("1234")),(customer.getBankAccount().getAccHolderName()), (customer.getBankAccount().getBalance()), (customer.getBankAccount().getAccType())));;
        }

        /*
             deposit and withdraw money
         */

        System.out.print("Enter your account number : ");
        String accNum = scanner.nextLine();

        //deposit money
        System.out.print("Enter the amount you want to deposit : ");
        double deposit = scanner.nextDouble();

        bank.deposit(accNum, deposit);

        //withdraw money
        System.out.print("Enter the amount you want to withdraw : ");
        double withdraw = scanner.nextDouble();

        bank.withdraw(accNum, withdraw);
    }
}