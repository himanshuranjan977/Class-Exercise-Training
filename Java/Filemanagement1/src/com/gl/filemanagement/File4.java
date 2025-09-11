package com.gl.filemanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File4 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
          ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Pineapple");
        try {
              try (FileWriter writer = new FileWriter("Fruits.txt")) {
                  for (String fruit : fruits) {
                      writer.write(fruit + "\n");  // Add newline manually
                  } }
            System.out.println(" Fruit names written to Fruits.txt using FileWriter.");
        } catch (IOException e) {
            System.out.println(" An error occurred while writing the file." +e.getMessage());
            
        }



    }


}
