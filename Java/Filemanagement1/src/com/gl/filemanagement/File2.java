package com.gl.filemanagement;

import java.io.FileWriter;
import java.io.IOException;

public class File2 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        try{
        FileWriter myWriter = new FileWriter("C:\\Users\\DELL\\Desktop\\Java\\cricket.txt ");

        myWriter.write("Today is saturday");
        myWriter.write("\nTommorow is Sunday");
        myWriter.close();
        System.out.println("Write operation Compleated");
        }
        catch(IOException ex){
            System.out.println("Some problem is file writing" +ex.getMessage());

        }
    
    }

}
