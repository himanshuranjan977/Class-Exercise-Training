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
            
            PanCard pan1 =new PanCard("P001");
            Employee emp1 = new Employee("Emp001",pan1);
            session.save(emp1);
            
            Bank bank1 =new Bank("ACOO1", emp1);
            Bank bank2 =new Bank("ACOO2", emp1);
            
            session.save(bank1);
            session.save(bank2);
            
            

            
            // Close the transaction
            tx.commit();

            // Close the connection / session
            session.close();
            
            
        } catch (Exception ex) {
            System.out.println("Error in Hibernate: " + ex.getMessage());
            
        }
    }
}
