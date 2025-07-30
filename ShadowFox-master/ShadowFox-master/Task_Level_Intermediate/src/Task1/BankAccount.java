package Task1;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive.");
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
