package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        //creating the bank instance
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        String resp = "y";

        int cusID = 123;

        while (resp.equals("y")) {
            String valEmail = null;
            String valPhone = null;

            //Input customer details

            logger.info("====== Customer Details ======");

            //customer name
            System.out.print("Enter your name : ");
            String customerName = scanner.next();

            //email
            System.out.print("Enter your email : ");
            String email = scanner.next();

            if (validateEmail(email)) {
                valEmail = email;
            } else {
                logger.warn("Invalid Pattern");
                break;
            }

            //contact number
            System.out.print("Enter your contactNumber : ");
            String phone = scanner.next();

            if (validatePhone(phone)) {
                valPhone = phone;
            } else {
                logger.warn("Invalid Pattern");
                break;
            }

            bank.addCustomer(cusID++, customerName, valEmail, valPhone);

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

                    logger.info("\n" + "===== Bank account created successfully =====");

                    //print details
                    System.out.println();
                    logger.info("===== Customer Details =====");
                    System.out.println("Name : " + customer.getCustomerName());
                    System.out.println("Email : " + customer.getEmail() + " ");
                    System.out.println("Contact : " + customer.getPhone());

                    System.out.println();
                    logger.info("===== Bank Account Details =====");
                    System.out.println("Account Holders Number : " + accNum);
                    System.out.println("Account Holders Name : " + holderName);
                    System.out.println("Balance : " + balance);
                    System.out.println("Account Type : " + accountType);

                    bank.addBankAccount(accNum, holderName, balance, accountType);

                    System.out.println("\n" + "Do you want to create another bank account(y/n) : ");
                    String res = scanner.next();

                    if (res.equalsIgnoreCase("y")) {
                        response = true;
                    } else {
                        response = false;
                    }
                }

                logger.info("\n" + "====== Enter the number of the action ======");
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

                            try {
                                //deposit money
                                System.out.print("Enter the amount you want to deposit : ");
                                double deposit = scanner.nextDouble();

                                if (deposit < 0) {
                                    throw new AmountException(deposit);
                                } else {
                                    bank.deposit(accNumberD, deposit);
                                }
                            } catch (AmountException e) {
                                logger.error("\n" + "Invalid amount");
                            }

                            break;

                        case 2:

                            //read account number
                            System.out.print("Enter your account number : ");
                            int accNumberW = scanner.nextInt();

                            try {
                                //withdraw money
                                System.out.print("Enter the amount you want to withdraw : ");
                                double withdraw = scanner.nextDouble();

                                if (withdraw < 0) {
                                    throw new AmountException(withdraw);
                                } else {
                                    bank.withdraw(accNumberW, withdraw);
                                }
                            } catch (AmountException e) {
                                logger.error("\n" + "Invalid Amount");
                            }
                            //withdraw money
//                        System.out.print("Enter the amount you want to withdraw : ");
//                        double withdraw = scanner.nextDouble();
//
//                        bank.withdraw(accNumberW, withdraw);

                            break;

                        case 3:

                            //list of bank accounts
                            for (BankAccount account : bank.getBankAccountList()) {
                                System.out.print(account.getAccNumber());
                                System.out.print("\t" + account.getAccType());
                                System.out.println("\t" + account.getBalance());

                                logger.info("\n" + "Transaction details");

                                for(Transactions t: account.getTransactionList()){
                                    System.out.print(t.getTransactionID());
                                    System.out.print("\t" + t.getTransactionType());
                                    System.out.print("\t" + t.getTransactionDate());
                                    System.out.println("\t" + t.getTransactionAmount());
                                }
                            }
                            break;
                    }

                    logger.info("\n" + "====== Enter the number of the action ======");
                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. View List of Bank Accounts");
                    System.out.println("4. Exit");

                    menu = scanner.nextInt();
                }
            }

            logger.info("\n" + "Add another customer(y/n) : ");
            resp = scanner.next();
        }
        //list of bank accounts
        for (Customer cus : bank.getCustomerList()) {
            System.out.print(cus.getCustomerID());
            System.out.print("\t" + cus.getCustomerName());
            System.out.print("\t" + cus.getEmail());
            System.out.println("\t" + cus.getPhone());
        }
    }


    private static boolean validateEmail(String email) {
        String valEmail = "^(.+)@(.+)$";

        return email.matches(valEmail);
    }

    private static boolean validatePhone(String phone) {
        String valPhone = "^[0-9]+$";

        return phone.matches(valPhone);
    }
}