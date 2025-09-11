package com.gl.serialize.example;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ClassroomResume {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        try{
        FileInputStream fin = new FileInputStream("C:\\Users\\DELL\\Desktop\\Java\\game.ser");
        ObjectInputStream in= new ObjectInputStream(fin);

        Student student = (Student)in.readObject();
        in.close();
        fin.close();

        System.out.println("Student information : " + student.name + " " + student.id + " " + student.age);
        }
        catch(Exception e){
            System.out.println("error in desentralise");
        }
    }

}
