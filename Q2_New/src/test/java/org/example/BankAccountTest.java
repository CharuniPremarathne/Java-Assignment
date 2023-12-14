package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount bankAccount1;

    @Test
    void testConstructor(){
        BankAccount bankAccount = new BankAccount(1234, "Ann", 0.0, "saving");
        List<BankAccount> accList = new ArrayList<>();

        assertEquals(1234, bankAccount.getAccNumber());
        assertEquals("Ann", bankAccount.getAccHolderName());
        assertEquals(0.0, bankAccount.getBalance());
        assertEquals("saving", bankAccount.getAccType());

        assertEquals(accList, bankAccount.getTransactionList());
    }

    @Test
    void testSetters(){
        BankAccount bankAccount = new BankAccount();

        bankAccount.setAccNumber(1234);
        bankAccount.setAccHolderName("Ann");
        bankAccount.setBalance(5000.0);
        bankAccount.setAccType("saving");

        assertEquals(1234, bankAccount.getAccNumber());
        assertEquals("Ann", bankAccount.getAccHolderName());
        assertEquals(5000.0, bankAccount.getBalance());
        assertEquals("saving", bankAccount.getAccType());
    }
    @Test
    void depositValidAmountUpdateBalance() {
        BankAccount bankAccount = new BankAccount();
        assertEquals(200, bankAccount.depositMoney(200));
    }

    @Test
    void depositInvalidAmountThrowsException(){
        BankAccount bankAccount = new BankAccount();
        assertThrows(AmountException.class, () -> {
            bankAccount.depositMoney((-300));
        });
    }

    @Test
    void negativeBalanceThrowsException() {
        BankAccount bankAccount = new BankAccount();
        assertThrows(BalanceException.class, () -> {
            bankAccount.withdrawMoney(300);
        });
    }

    @Test
    void BankAccount(){
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setAccNumber(1234);
        bankAccount2.setAccHolderName("Perera");
        bankAccount2.setAccType("saving");
        bankAccount2.setBalance(500.00);

        assertEquals(1234, bankAccount2.getAccNumber());
        assertEquals("Perera", bankAccount2.getAccHolderName());
        assertEquals("saving", bankAccount2.getAccType());
        assertEquals(500.00, bankAccount2.getBalance());
    }
}