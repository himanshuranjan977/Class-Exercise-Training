package com.gl.collection.example;

import java.util.LinkedList;

public class Classroom {
    public static void main(String[] args) {
        LinkedList<Student> students =new LinkedList<>();
        students.add(new Student("Ashok",10));

        //students.add(s1);
        
        students.add(new Student("Shiva",12));
        students.add(new Student("Shiva",20));
        students.add(new Student("Ramaya",12));
        students.addFirst(new Student("Poorna",15));
        students.addLast(new Student("Kavi",28));
        //System.out.println(students);

        for(Student temp  : students){
            temp.printDetails();
        }

    }

}
