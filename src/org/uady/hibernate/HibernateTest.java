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
		user.setUserName("Hortencia Polanco");
		user.setJoinedDate(new Date());
		
		
		Address address = new Address();
		address.setCity("Monterrey");
		address.setState("Nuevo Leon");
		address.setStreet("Calle 42");
		address.setCode("97370");
		
		user.setAddress(address);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}

}
