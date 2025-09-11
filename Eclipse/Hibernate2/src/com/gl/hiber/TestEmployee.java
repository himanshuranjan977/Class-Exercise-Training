package com.gl.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEmployee {
	
	public static void main(String[] args) {
		try {
			SessionFactory factory=new Configuration().configure().buildSessionFactory();
			
			Session session= factory.openSession();
			
			Transaction tx= session.beginTransaction();
			
			//Employee e1= new Employee("Suraj",28,"Manager","Male");
			//session.save(e1);
			
			//Employee e2= new Employee("Manoj",25,"Intern","Male");
			//session.save(e2);
			
			//Employee e3= new Employee("Rushali",32,"HR","Female");
			//session.save(e3);
			
			//Employee e4= new Employee("Aman",38,"Team Lead","Male");
			//session.save(e4);
			
			//Employee e5= new Employee("Gomez",31,"HR","Male");
			//session.save(e5);
			
			//Employee e6= new Employee("Kritika",38,"Manager","Female");
			//session.save(e6);
			
			
			
			//Employee e2= new Employee(8,"Kritika",38,"HR","Female");
			//session.update(e2);
			Employee e2= new Employee(8,"Ram",19,"HR","Male");
			session.update(e2);
			
			
			//session.delete(new Employee(13));
			
			
			tx.commit();
			
			session.close();
			
		}
		catch(Exception ex) {
			System.out.println("Error in hiber : "+ex.getMessage());
		}
	}
}


