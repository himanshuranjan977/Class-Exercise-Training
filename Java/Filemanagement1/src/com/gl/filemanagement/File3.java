package com.gl.filemanagement;

import java.io.FileWriter;
import java.io.IOException;

public class File3 {

    @SuppressWarnings("ConvertToTryWithResources")    
    public static void main(String[] args) {
        // Step 1: Declare and initialize the array
        int[] numbers = {10, 11, 12}; // You can change these values

        // Step 2: Calculate the sum using a loop
        int total = 0;
        for (int num : numbers) {
            total += num;
        }

        // Step 3: Write the total to a file
        
         try {
            FileWriter writer = new FileWriter("sum.txt");
            writer.write("Total sum is: " + total);
            writer.close();
            System.out.println("✅ Sum written to file successfully.");
        } catch (IOException e) {
            System.out.println("❌ An error occurred.");
            
        }


    }

}
