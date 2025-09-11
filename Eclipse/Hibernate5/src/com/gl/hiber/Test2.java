
package com.gl.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try {
            // Loading the Hibernate configuration
            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            // Open a session
            Session session = factory.openSession();

            // Open a transaction
            Transaction tx = session.beginTransaction();
            
            PanCard pan = new PanCard("ABCDE1234F");
            Employee emp = new Employee("Himanshu Ranjan", pan);

            session.save(emp);   // Cascade saves PanCard too
            session.getTransaction().commit();
            System.out.println("Employee Inserted Successfully!");

            // Delete
           
            session.beginTransaction();
            Employee e = session.get(Employee.class, 3);
           
            session.delete(e);  // Cascade deletes PanCard too
            
            //session.getTransaction().commit();
            System.out.println("Employee Deleted Successfully!");
            
            
            
            // Close the transaction
            tx.commit();

            // Close the connection / session
            session.close();
            
            
        } catch (Exception ex) {
            System.out.println("Error in Hibernate: " + ex.getMessage());
            
        }
    }
}