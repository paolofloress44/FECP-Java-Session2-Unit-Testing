package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    /*
    1. deposit a valid amount
    2. deposit an invalid amount
    3. withdraw an invalid amount
    4. withdraw a valid amount
    5. withdraw an amount that exceeds the balance
    6. test the getAccountNumber() method
    7. test creation of bank account without deposits
    */

    private BankAccount bankAccount;
    @BeforeEach
    void setup() {
        bankAccount = new BankAccount(001, "John Pork", 1000.00);
    }

    /*@Test
    void shouldReturnCorrectSumWhenAddingToNumber(){
        float actual = calculator.sum(2,1);
        assertEquals(3, actual);
    }*/

    @Test
    void depositAValidAmount() {
        double actual = bankAccount.addDeposit(500);
        assertEquals(500, actual);
    }
    @Test
    void depositAnInvalidAmount() {
        double actual = bankAccount.addDeposit(-1);
        assertEquals(-1, actual);
    }
    @Test
    void withdrawAValidAmount() {
        double actual = bankAccount.withdrawThat(100);
        assertEquals(100, actual);
    }
    @Test
    void withdrawAnInvalidAmount() {
        double actual = bankAccount.withdrawThat(-50);
        assertEquals(-50, actual);
    }
    @Test
    void testGetAccountMethod(){
        int actual = bankAccount.getAccountNumber();
        assertEquals(1, actual);
    }
    @Test
    void testCreationOfBankWithoutDeposits(){
        BankAccount newAccount = new BankAccount(002, "Marvin Beak", 0.0);
        int actual = newAccount.getAccountNumber();
        assertEquals(2, actual);
    }

}