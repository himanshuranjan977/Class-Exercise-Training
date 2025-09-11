package com.gl.transfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BankTransferSerializer {
    public static void main(String[] args) {
        BankTransfer transfer = new BankTransfer("Alice", "Bob", 2500.75);

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java\\transfer.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(transfer);
            System.out.println("Serialized data is saved in transfer.ser");

        } catch (IOException i) {
            System.out.println("Shows Error");
        }

    }

}
