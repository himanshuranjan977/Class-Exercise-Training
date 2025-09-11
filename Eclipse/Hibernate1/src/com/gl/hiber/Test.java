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
            
           //Mobile ml = new Mobile("Samsung", "M001", 10000.00, 4, 64, "White");
            //session.save(ml);
            
            //new Mobile("Vivo", "M001", 10000.00, 4, 64, "White");
            //Mobile vivo = new Mobile("Vivo", "M002", 12000.00, 3, 64, "Orange");
            //session.save(vivo);   // ✅ will be inserted
            
            //Mobile m1 = new Mobile(1, "Vivo", "M002", 15000.00, 3, 64, "Orange");
            //session.update(m1);
            
            

            //session.delete(new Mobile(1, "Vivo", "M002", 15000.00, 3, 64, "Orange"));

         // Delete by ID only ✅ (requires the extra constructor)
         session.delete(new Mobile(4));





            
            // Close the transaction
            tx.commit();

            // Close the connection / session
            session.close();
            
            
        } catch (Exception ex) {
            System.out.println("Error in Hibernate: " + ex.getMessage());
            
        }
    }
}