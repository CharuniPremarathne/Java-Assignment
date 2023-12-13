package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void findAccountReturnAccount() {
        Bank bank = new Bank();
        assertNotNull(bank.findAccount(1234));
    }

    @Test
    void findCustomerReturnCustomer() {
        Bank bank = new Bank();
        assertNotNull(bank.findCustomer("asd"));
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