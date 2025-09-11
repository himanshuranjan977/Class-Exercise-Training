package com.gl.filemanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File7 {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("unused")
            FileWriter fw = new FileWriter("C:\\Users\\DELL\\Desktop\\Java\\cricket.txt" );
            BufferedWriter bw =new BufferedWriter(fw);

            bw.write("India vs England 5th Test Match ");
            bw.newLine();
            bw.write("England leads the Series by 2 to 1");

            bw.close();
            fw.close();
            System.out.println("Program Executed Successfully");
        } catch (IOException e) {
            System.out.println("Wrong Execution"+e);
        }
    }

}
