package com.gl.hiber;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try {
            // Loading the Hibernate configuration
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            // Open a session
            Session session = factory.openSession();

            // Open a transaction
            Transaction tx = session.beginTransaction();
            
         // 🔹 Create Genders
            Gender male = new Gender("Male");
            Gender female = new Gender("Female");

            // 🔹 Create Courses
            Course java = new Course("Java");
            Course python = new Course("Python");
            Course react = new Course("React");

            // 🔹 Create Students
            Student s1 = new Student("Himanshu", male, Arrays.asList(java, python));
            Student s2 = new Student("Riya", female, Arrays.asList(react, python));

            // 🔹 Create Vehicles
            Vehicle v1 = new Vehicle("Car", s1);
            Vehicle v2 = new Vehicle("Scooty", s2);

            

            // 🔹 Save genders first (important!)
            session.save(male);
            session.save(female);
            
            session.save(v1);   // then vehicle
            session.save(v2);

            // 🔹 Save students (cascade saves vehicle + courses)
            session.save(s1);
            session.save(s2);
            
            

            

            
            // Close the transaction
            tx.commit();

            // Close the connection / session
            session.close();
            
            
        } catch (Exception ex) {
            System.out.println("Error in Hibernate: " + ex.getMessage());
            
        }
    }
}
