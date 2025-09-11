package com.gl.jdt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Prob1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        int age =22;
        try {
            FileWriter writer =new FileWriter("Print.txt");
            writer.write("Your age is : " + age);
            writer.close();
            System.out.println("Age has been written to the file");

            
        } catch (IOException e) {
            System.out.println("Error while to do the file : " + e.getMessage());
        }
        
        try {
            FileReader reader = new FileReader("print.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reading from file: " + line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }

    }

}
