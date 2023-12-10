package org.example;

import java.util.Scanner;
import java.util.Set;

public class BankApplication {
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



        /*
               Input bank account details
         */

        System.out.println("====== Bank Account Details ======");

        //account number
        System.out.print("Enter Account Number : ");
        String accNumber = scanner.nextLine();

        //account holder name
        System.out.print("Enter Account Holder Name : ");
        String accHolderName = scanner.nextLine();

        //balance
        System.out.print("Enter Balance : ");
        float balance = scanner.nextFloat();

        //account type
        System.out.print("Enter Account Type : ");
        String accType = scanner.next();

        //create customerID
        int customerID;


        //add bank customer details to the customerList
        bank.addCustomer("123", customerName, email, phone);

        //add bank account details to the bankAccountList
        bank.addBankAccount(accNumber, accHolderName, balance, accType);

        /*
            print customer and bank account details
         */

        //retrieve customer and bank accounts lists of object "bank"
        Set<Customer> customersList = bank.getCustomerList();
        Set<BankAccount> accountsList = bank.getBankAccountList();

        System.out.println("================================================");
        for(Customer customer : customersList){
            System.out.print(customer.getCustomerName() + " ");
            System.out.print(customer.getEmail() + " ");
            System.out.println(customer.getPhone());
        }

        for(BankAccount bankAccount : accountsList){
            System.out.print(bankAccount.getAccNumber() + " ");
            System.out.print(bankAccount.getAccHolderName() + " ");
            System.out.print(bankAccount.getAccType() + " ");
            System.out.print(bankAccount.getBalance() + " ");
        }
    }
}