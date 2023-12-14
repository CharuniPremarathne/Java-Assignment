package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {

    LocalDate date = LocalDate.parse("2020-01-08");
    @Test
    void testConstructor() {
        Transactions transactions = new Transactions("123", date, 500.00, "deposit");

        assertEquals("123",transactions.getTransactionID());
        assertEquals(date,transactions.getTransactionDate());
        assertEquals(500.0,transactions.getTransactionAmount());
        assertEquals("deposit",transactions.getTransactionType());
    }

    @Test
    void testSetters(){
        LocalDate date = LocalDate.parse("2020-01-08");

        Transactions transactions = new Transactions();

        transactions.setTransactionID("123");
        transactions.setTransactionDate(date);
        transactions.setTransactionAmount(500);
        transactions.setTransactionType("deposit");
        
        assertEquals("123",transactions.getTransactionID());
        assertEquals(date,transactions.getTransactionDate());
        assertEquals(500.0,transactions.getTransactionAmount());
        assertEquals("deposit",transactions.getTransactionType());
    }
}