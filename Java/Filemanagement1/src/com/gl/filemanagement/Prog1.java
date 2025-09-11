package com.gl.filemanagement;

import java.io.FileWriter;
import java.io.IOException;

public class Prog1 {
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("TableOf3.txt");

            for (int i = 1; i <= 10; i++) {
                int result = 3 * i;
                writer.write("3 * " + i + " = " + result + "\n");
            }

            writer.close();
            System.out.println("Multiplication table of 3 written to TableOf3.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            
        }

    }

}
