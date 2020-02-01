package jm.rbs.customer.account.model;

import javax.validation.constraints.PositiveOrZero;
import java.util.Objects;

public class Account {

    private String accountNumber;
    private String name;
    @PositiveOrZero(message = "Balance is too low!! It should be greater than zero")
    private double balance;

    public Account(String accountNumber, String name, @PositiveOrZero double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getAccountNumber().equals(account.getAccountNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber());
    }
}
