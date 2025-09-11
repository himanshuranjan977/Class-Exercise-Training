package com.gl.serialize.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Classroom {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try{
        Student s1 =new Student(1,"john",20);

        FileOutputStream fileout = new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java\\game.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileout);

        out.writeObject(s1);
        out.close();
        fileout.close();

        System.out.println("Object Specilized");

        } catch(IOException e){
            System.out.println("error is Serialization");


        }
    }

}
