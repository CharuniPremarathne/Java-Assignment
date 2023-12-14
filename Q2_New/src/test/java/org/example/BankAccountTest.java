package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount bankAccount1;
    BankAccount bankAccount2 = new BankAccount(1235, "Perera", 3000.0, "saving");

    BankAccountTest() {
        bankAccount1 = new BankAccount(1234, "Ann", 5000.0, "saving");
    }

    @Test
    void balancePlusDeposit() {
        //BankAccount bankAccount = new BankAccount();
        assertEquals(5200, bankAccount1.depositMoney(200));
    }

    @Test
    void negativeValuesThrowsException() {
        BankAccount bankAccount = new BankAccount();
        assertThrows(BalanceException.class, () -> {
            bankAccount.withdrawMoney(2);
        });
    }
}