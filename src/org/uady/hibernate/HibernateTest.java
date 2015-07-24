package org.uady.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.uady.dto.Address;
import org.uady.dto.UserDetails;
import org.uady.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails  user = new UserDetails();
		user.setUserName("Yuceli Polanco");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Chevy");
		
		user.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
	}

}
