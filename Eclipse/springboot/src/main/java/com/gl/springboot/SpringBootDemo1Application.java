package com.gl.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemo1Application implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("Server about to start...");
        SpringApplication.run(SpringBootDemo1Application.class, args);
        System.out.println("Server started successfully!");
    }

    @Override
    public void run(String... args) throws Exception {
        // Create a Student object
        Student s1 = new Student("s1", 25, 56.500);

        // print the name of the student
        System.out.println("Student name: " + s1.getName());
    }
}
