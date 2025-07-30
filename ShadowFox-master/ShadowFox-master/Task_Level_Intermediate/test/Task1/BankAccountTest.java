package Task1;


import Task1.BankAccount;
import Task1.BankAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("Ravi", 1000.0);
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        account.withdraw(2000.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-100);
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(100);
        account.withdraw(50);
        List<String> history = account.getTransactionHistory();
        assertTrue(history.contains("Deposited: 100.0"));
        assertTrue(history.contains("Withdrawn: 50.0"));
    }
}
