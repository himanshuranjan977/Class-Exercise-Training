package com.gl.hiber;

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
            
         // Create Student objects
           /* Student s1 = new Student("s1");
            Student s2 = new Student("s2");

            // Create Bank objects
            Bank b1 = new Bank("A001", s1);  
            Bank b2 = new Bank("A002", s1);

            Bank b3 = new Bank("A003", s2);
            Bank b4 = new Bank("A004", s2);
            Bank b5 = new Bank("A005", s2);

            // Save using Hibernate session
            session.save(s1);
            session.save(s2);

            session.save(b1);
            session.save(b2);
            session.save(b3);
            session.save(b4);
            session.save(b5);*/
            
         // Fetch a Bank by primary key
            Bank b1 = session.get(Bank.class, 3);
            System.out.println("Bank: " + b1.getAcNumber());
            System.out.println("Student: " + b1.getStudent().getName());

            // Fetch a Student by primary key
            Student s2 = session.get(Student.class, 2);
            System.out.println("Student: " + s2.getName());

            // Loop through all banks of that student
            for (Bank temp : s2.getBanks()) {
                System.out.println("AC: " + temp.getAcNumber());
            }
            
            
            
            // Close the transaction
            tx.commit();

            // Close the connection / session
            session.close();
            
            
        } catch (Exception ex) {
            System.out.println("Error in Hibernate: " + ex.getMessage());
            
        }
    }
}
