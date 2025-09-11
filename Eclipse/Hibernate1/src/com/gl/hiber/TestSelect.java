package com.gl.hiber;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSelect {
	
	public static void main(String args[]) {
		try {
			SessionFactory factory=new Configuration().configure().buildSessionFactory();
			
			Session session= factory.openSession();
			
			Transaction tx= session.beginTransaction();
			
			Mobile m1=session.get(Mobile.class, 2);
			System.out.println("Mobile company : "+m1.getCompany());
			
			List<Mobile> mobiles=session.createQuery("from Mobile",Mobile.class).list();
			for(Mobile temp: mobiles) {
				System.out.println("Name : "+temp.getCompany());
			}
			
			tx.commit();
			
			session.close();
		}
		catch(Exception ex) {
			System.out.println("Error in hiber : "+ex.getMessage());
		}
	}
}