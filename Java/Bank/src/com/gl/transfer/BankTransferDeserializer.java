package com.gl.transfer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BankTransferDeserializer {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\DELL\\Desktop\\Java\\transfer.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            BankTransfer transfer = (BankTransfer) in.readObject();

            System.out.println("Deserialized BankTransfer Object:");
            System.out.println("From: " + transfer.getFromName());
            System.out.println("To: " + transfer.getToName());
            System.out.println("Amount: " + transfer.getTransferAmount());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error");
        }

    }

}
