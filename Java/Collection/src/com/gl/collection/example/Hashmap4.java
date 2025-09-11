package com.gl.collection.example;

import java.util.Map;
import java.util.TreeMap;

public class Hashmap4 {

    int rollNo;
    String name;
    double marks;

    // Constructor
    public Hashmap4(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // To display student info
    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }

    public static void main(String[] args) {
        TreeMap<String, Hashmap4> students = new TreeMap<>();

        // Adding 5 students
        students.put("S003", new Hashmap4(3,"Himanshu" ,89.5));
        students.put("S001", new Hashmap4(1, "Ravi", 91.0));
        students.put("S005", new Hashmap4(5, "Neha", 76.3));
        students.put("S002", new Hashmap4(2, "Arjun", 88.0));
        students.put("S004", new Hashmap4(4, "Meena", 83.7));

        // Iterating and printing student details
        for (Map.Entry<String, Hashmap4> entry : students.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Student Info: " + entry.getValue());
            System.out.println();
        }

    }

}
