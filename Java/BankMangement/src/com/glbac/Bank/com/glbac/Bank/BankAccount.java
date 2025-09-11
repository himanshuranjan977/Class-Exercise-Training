package com.glbac.Bank;

public abstract class BankAccount {
    protected String accountNumber;
    protected String accountName;
    protected double balance;

    public BankAccount(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public abstract void printDetails();
}
