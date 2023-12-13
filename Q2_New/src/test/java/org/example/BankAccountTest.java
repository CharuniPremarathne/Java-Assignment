package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void zeroPlusTwoShouldEqualTwo() {
        BankAccount bankAccount = new BankAccount();
        assertEquals(2, bankAccount.depositMoney(2));
    }

    @Test
    void zeroMinusTwoThrowsException() {
        BankAccount bankAccount = new BankAccount();
        assertThrows(BalanceException.class, () -> {
            bankAccount.withdrawMoney(2);
        });
    }
}