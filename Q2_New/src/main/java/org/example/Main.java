package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //creating the bank instance
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);


        //Input customer details

        System.out.println("====== Customer Details ======");

        //customer name
        System.out.print("Enter your name : ");
        String customerName = scanner.next();

        //email
        System.out.print("Enter your email : ");
        String email = scanner.next();

        //contact number
        System.out.print("Enter your contactNumber : ");
        String phone = scanner.next();

        bank.addCustomer("12345", customerName, email, phone);

        //retrieve customer and bank accounts lists of object "bank"
        List<Customer> customersList = bank.getCustomerList();

        Boolean response = true;

        for (Customer customer : customersList) {

            //create bank account

            int accNumber = 1234;

            while (response) {
                customer.getBankAccount().setAccNumber(accNumber++);

                //set account holder name to the customer name
                customer.getBankAccount().setAccHolderName(customerName);

                //input account type
                System.out.print("Enter the Account Type : ");
                String accType = scanner.next();
                customer.getBankAccount().setAccType(accType);

                int accNum = customer.getBankAccount().getAccNumber();
                String holderName = customer.getBankAccount().getAccHolderName();
                String accountType = customer.getBankAccount().getAccType();
                Double balance = customer.getBankAccount().getBalance();


                System.out.println("\n" + "===== Bank account created successfully =====");
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

                System.out.print("\n" + "Do you want to create another bank account(y/n) : ");
                String res = scanner.next();

                if (res.equalsIgnoreCase("y")) {
                    response = true;
                } else {
                    response = false;
                }
            }

            System.out.println("\n" + "====== Enter the number of the action ======");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View List of Bank Accounts");
            System.out.println("4. Exit");

            int menu = scanner.nextInt();

            while (menu != 4) {
                switch (menu) {
                    case 1:
                        //read account number
                        System.out.print("Enter your account number : ");
                        int accNumberD = scanner.nextInt();

                        //deposit money
                        System.out.print("Enter the amount you want to deposit : ");
                        double deposit = scanner.nextDouble();

                        bank.deposit(accNumberD, deposit);

                        break;

                    case 2:

                        //read account number
                        System.out.print("Enter your account number : ");
                        int accNumberW = scanner.nextInt();

                        //withdraw money
                        System.out.print("Enter the amount you want to withdraw : ");
                        double withdraw = scanner.nextDouble();

                        bank.withdraw(accNumberW, withdraw);

                        break;

                    case 3:

                        //list of bank accounts
                        for (BankAccount account : bank.getBankAccountList()) {
                            System.out.print(account.getAccNumber());
                            System.out.print("\t" + account.getAccType());
                            System.out.println("\t" + account.getBalance());
                        }

                        //display transaction history
                        System.out.println(customer.getBankAccount().getTransactionList());

                        break;
                }

                System.out.println("\n" + "====== Enter the number of the action ======");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. View List of Bank Accounts");
                System.out.println("4. Exit");

                menu = scanner.nextInt();
            }
        }
    }
}