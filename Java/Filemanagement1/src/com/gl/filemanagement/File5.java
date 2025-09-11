package com.gl.filemanagement;

import java.io.FileReader;
import java.io.IOException;


public class File5 {

    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try{
        FileReader reader = new FileReader("C:\\Users\\DELL\\Desktop\\Java\\cricket.txt");
        int charAscii ;

        while((charAscii= reader.read()) != -1){
            System.out.println((char) charAscii);
        }
        reader.close();
       /*  charAscii =reader.read();
        System.out.println((char) charAscii);

        charAscii =reader.read();
        System.out.println((char) charAscii);

        charAscii =reader.read();
        System.out.println((char) charAscii);

        charAscii =reader.read();
        System.out.println((char) charAscii);*/
        }
        catch(IOException e){
            System.out.println("Error is reading the file" + e.getMessage());
        }

    }

}
