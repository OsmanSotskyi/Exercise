package utils;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String number;
    private String name;
    private List<Transaction> transactions;
    private double balance;
    private String statement;

    public Account(String number, String name) {
        this.number = number;
        this.name = name;
        this.transactions = new ArrayList<>();
        this.balance = 0.0;
    }

    public void deposit(Transaction transaction) {
        transactions.add(transaction);
        balance += transaction.getAmount();
    }

    public void withdraw(Transaction transaction) {
        transactions.add(transaction);
        balance -= transaction.getAmount();
    }

    public void produceStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Account: ").append(number).append("\n");
        sb.append("Balance: ").append(String.format("%.2f", balance)).append("\n");
        for (Transaction t : transactions) {
            sb.append(t.getType()).append(" ").append(t.getAmount()).append("\n");
        }
        statement = sb.toString();
    }

    public String getStatement() {
        return statement;
    }
}