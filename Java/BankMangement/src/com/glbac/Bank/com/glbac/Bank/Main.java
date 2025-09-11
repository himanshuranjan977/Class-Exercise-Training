package com.glbac.Bank;

public class Main {
    public static void main(String[] args) {
        SavingAccount savingAcc = new SavingAccount("SA1001", "Himanshu", 15000.0);
        CurrentAccount currentAcc = new CurrentAccount("CA2001", "Ranjan Enterprises", 35000.0);

        savingAcc.printDetails();
        System.out.println();
        currentAcc.printDetails();
    }
}