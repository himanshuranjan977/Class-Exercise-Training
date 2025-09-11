package com.gl.Person;

import java.util.Arrays;

public class School {
    public static void main(String[] args) {
        int[] studentMarks ={88,76,90,84,79};
        Student student = new Student("Himanshu", 20, studentMarks);
        System.out.println("=== Students Details ====");
        student.displayDetails();
        System.out.println("=== Average marks ===");
        System.out.println("Marks : " + Arrays.toString(studentMarks));
        student.printAverage();

    }

}
