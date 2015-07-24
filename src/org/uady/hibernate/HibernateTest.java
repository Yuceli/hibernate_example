package org.uady.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.uady.dto.Address;
import org.uady.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails  user = new UserDetails();
		user.setUserName("Yuceli Polanco");
		
		Address address1 = new Address();
		address1.setStreet("Calle 43");
		address1.setCity("Merida");
		address1.setState("Yucatán");
		address1.setCode("97370");
		
		Address address2 = new Address();
		address2.setStreet("Calle 43");
		address2.setCity("Merida");
		address2.setState("Yucatán");
		address2.setCode("97370");
		
		user.getListOfAddress().add(address1);
		user.getListOfAddress().add(address2);
	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println(user.getListOfAddress().size());
		
		
		
		
	}

}
