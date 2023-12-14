package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank = new Bank();


    @Test
    void testConstructor(){
        List<Customer> cusList = new ArrayList<>();
        List<BankAccount> accList = new ArrayList<>();

        assertNotNull(cusList);
        assertNotNull(accList);

        assertEquals(cusList, bank.getCustomerList());
        assertEquals(accList, bank.getBankAccountList());
    }

    @Test
    void testAddCustomer(){
        List<Customer> cusList = new ArrayList<>();

        bank.addCustomer(123, "Ann", "ann@email.com", "0123456789");

        assertNotNull(cusList);
    }

    @Test
    void testAddAccount(){
        List<BankAccount> accList = new ArrayList<>();

        bank.addBankAccount(123, "Ann", 500.0, "saving");

        assertNotNull(accList);
    }

    @Test
    void testRemoveBankAccount(){
        List<BankAccount> accList = new ArrayList<>();

        bank.addBankAccount(123, "Ann", 500.0, "saving");

        bank.removeBankAccount(123);

        assertEquals(0, accList.size());
    }


    @Test
    void testRemoveCustomer(){
        List<Customer> cusList = new ArrayList<>();

        bank.addCustomer(123, "Ann", "ann@email.com", "0123456789");

        bank.removeCustomer("ann@email.com");

        assertEquals(0, cusList.size());
    }

    @Test
    void findAccountReturnAccount() {

        bank.addBankAccount(123, "Ann", 500.0, "saving");

        assertNotNull(bank.findAccount(123));
    }

    @Test
    void findAccountDisplayErrorMessage() {

        bank.addBankAccount(123, "Ann", 500.0, "saving");

        assertEquals(null, bank.findAccount(12345));
    }


    @Test
    void findCustomerReturnCustomer() {
        bank.addCustomer(123, "Ann", "ann@email.com", "0123456789");

        assertNotNull(bank.findCustomer("ann@email.com"));
    }

    @Test
    void findCustomerDisplayReturnMessage() {
        bank.addCustomer(123, "Ann", "ann@email.com", "0123456789");

        assertEquals(null, bank.findCustomer("annperera@email.com"));
    }

    @Test
    void depositThrowsNullPointerException() {
        Bank bank = new Bank();
        assertThrows(NullPointerException.class, () -> {
            bank.deposit(123, 100.0);
        });
    }

    @Test
    void withdrawThrowsNullPointerException() {
        Bank bank = new Bank();
        assertThrows(NullPointerException.class, () -> {
            bank.withdraw(123, 100.0);
        });
    }

}