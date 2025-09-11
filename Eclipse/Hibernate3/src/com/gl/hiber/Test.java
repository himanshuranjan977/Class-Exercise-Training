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
            
            /*Teacher t1 =new Teacher("Santosh",30);
            Aadhar a1 = new Aadhar("A0001",t1);
            
            session.save(t1);
            session.save(a1);
            */
            Teacher t1 = session.get(Teacher.class, 1);
            System.out.println("Teacher name : " + t1.getName());
            System.out.println("Aadhar number : " + t1.getAadhar().getAadharNumber());

            Aadhar a1 = session.get(Aadhar.class, 1);
            System.out.println("Aadhar number : " + a1.getAadharNumber());

            System.out.println("Teacher name : " + a1.getTeacher().getName());
            
            // Close the transaction
            tx.commit();

            // Close the connection / session
            session.close();
            
            
        } catch (Exception ex) {
            System.out.println("Error in Hibernate: " + ex.getMessage());
            
        }
    }
}