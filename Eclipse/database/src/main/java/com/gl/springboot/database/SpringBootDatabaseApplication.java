package com.gl.springboot.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDatabaseApplication implements CommandLineRunner {

    // Injecting the repository
    @Autowired
    StudentService studentService;
   // private StudentRepo studentRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Creating a student object
        //Student s1 = new Student("Shyam", 3);
        //studentService.insertStudent(s1);
        /*Student s2 = new Student("Ram", 20);
        Student s3 = new Student("Krishna", 20);*/

        // Saving it to the database
        /*List<Student> students = new ArrayList<>();
        students.add(s1);
        //students.add(s2);
        //students.add(s3);
        
        studentRepo.saveAll(students);*/
        
    	
    	/*Student Himanshu =new Student("Ranjan",22);
    	Himanshu.setId(2);
    	studentRepo.save(Himanshu);
    	*/
    	/*Student Himanshu =new Student();
    	Himanshu.setId(2);
    	studentRepo.delete(Himanshu);*/
    	/*Student s1 =new Student("Siva",30);
    	studentService.insertStudent(s1);
    	*/
    	/*Student s1 = new Student("Alice", 21);
        Student s2 = new Student("Bob", 22);
        Student s3 = new Student("Charlie", 23);

        // Convert them into a list
        List<Student> studentList = Arrays.asList(s1, s2, s3);

        // Insert the list using service function
        studentService.insertManyStudents(studentList);
        */
    	/*
    	List<Student> allStudents = studentService.getAllStudents();

    	for (Student temp : allStudents) {
    	    System.out.println("Id: " + temp.getId());
    	    System.out.println("Name: " + temp.getName());
    	    System.out.println("Age: " + temp.getAge());
    	    System.out.println("==============");
    	}
    	*/
    	/*
    	Student student = studentService.getStudentById(4);

    	if (student != null) {
    	    System.out.println("name : " + student.getName());
    	} else {
    	    System.err.println("cannot find the student");
    	}
    	*/
    	
    	// get all students in the name order
    	List<Student> allStudents = studentService.getAllStudentsOrderByName();

    	for (Student temp : allStudents) {
    	    System.out.println("Id: " + temp.getId());
    	    System.out.println("Name: " + temp.getName());
    	    System.out.println("================");
    	}
        System.out.println("Student saved successfully!");
    }
}
