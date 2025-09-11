package com.glbac.Bank;

public class SavingAccount extends BankAccount {

    public SavingAccount(String accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }

    @Override
    public void printDetails() {
        System.out.println("----- Saving Account -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: $" + balance);
    }
}
