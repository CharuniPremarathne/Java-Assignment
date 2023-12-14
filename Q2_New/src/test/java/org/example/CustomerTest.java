package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testConstructor(){
        BankAccount bankAccount = new BankAccount();
        Customer customer = new Customer(123, "Ann", "ann@email.com", "0714892631");

        assertEquals(123, customer.getCustomerID());
        assertEquals("Ann", customer.getCustomerName());
        assertEquals("ann@email.com", customer.getEmail());
        assertEquals("0714892631", customer.getPhone());
        assertNotNull(customer.getBankAccount());
    }
}