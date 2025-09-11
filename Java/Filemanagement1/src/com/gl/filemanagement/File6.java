package com.gl.filemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File6 {
    public static void main(String[] args) {
        try{
        FileReader reader = new FileReader("C:\\Users\\DELL\\Desktop\\Java\\cricket.txt ");


         BufferedReader br = new BufferedReader(reader);
         String line ="";
         while((line =br.readLine()) != null){
            System.out.println(line);
         }
         br.close();
         reader.close();

        }
        catch(IOException e){
            System.out.println(e);

        }
        
    }
   

}
