package com.gl.spring;



public class Student {
    private String name;
    private int examNumber;
    private String gender;
    private int age;

    // Default constructor
    public Student() {
        //System.out.println("Default constructor called...");
    }

    // Constructor with 2 args
    public Student(String name, int examNumber) {
        this.name = name;
        this.examNumber = examNumber;
    }

    // Constructor with all fields
    public Student(String name, int examNumber, String gender, int age) {
        this.name = name;
        this.examNumber = examNumber;
        this.gender = gender;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public int getExamNumber() { return examNumber; }
    public String getGender() { return gender; }
    public int getAge() { return age; }

    // ✅ Function to print all details
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Exam Number: " + examNumber);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("----------------------------");
    }
}


