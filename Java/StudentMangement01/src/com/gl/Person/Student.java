package com.gl.Person;

public class Student extends Person implements Mark {
    private final int[] marks;

    public Student(String name, int age, int[] marks) {
        super(name, age);
        this.marks = marks;
    }

   
    @Override
    public void printAverage() {
        if (marks == null || marks.length == 0) {
            System.out.println("No marks available.");
            return;
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double average = (double) sum / marks.length;
        System.out.println("Average Marks: " + average);
    }
}