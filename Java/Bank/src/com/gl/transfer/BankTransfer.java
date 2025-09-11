package com.gl.transfer;

import java.io.Serializable;

public class BankTransfer implements Serializable{
    String fromName;
    String toName;
    double transferAmount;

    public BankTransfer(String fromName, String toName, double transferAmount) {
        this.fromName = fromName;
        this.toName = toName;
        this.transferAmount = transferAmount;
    }

    public String getFromName() {
        return fromName;
    }

    public String getToName() {
        return toName;
    }

    public double getTransferAmount() {
        return transferAmount;
    
    }

}
