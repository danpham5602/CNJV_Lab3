package net.codejava.hibernate;

import java.util.List;

import javax.management.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Order;

public class PhoneDAO {
	private SessionFactory sessionFactory;
	public void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	public void exit() {
		sessionFactory.close();
	}
	public boolean add(Phone p)
	{
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		if(session.save(p)==null) {
			return false;
		}
		session.getTransaction().commit();
		session.close();
		exit();
		return true;
	}
	public Phone get(int id)
	{
		setup();
		Session session = sessionFactory.openSession();
		Phone a = session.get(Phone.class, id);
		session.close();
		exit();
		return a;
	}
	public List<Phone> getAll()
	{
		try {
		List<Phone> phones;
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		phones = session.createQuery("FROM Phone").list();
		if(phones.size() > 0)
		{
			session.getTransaction().commit();
			session.close();
			exit();
			return phones;
		}
		session.getTransaction().commit();
		session.close();
		exit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean remove(int id) 
	{
		
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Phone a = new Phone();
		a = session.get(Phone.class, id);
		session.delete(a);
		session.getTransaction().commit();
		session.close();
		exit();
		
		return true;
	}
	public boolean remove(Phone p) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(p);
		session.getTransaction().commit();
		session.close();
		exit();
		return true;
		
	}
	public boolean update(Phone p) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Phone a = session.get(Phone.class, p.getID());
		a.setColor(p.getColor());
		a.setCountry(p.getCountry());
		a.setName(p.getName());
		a.setQuantity(p.getQuantity());
		a.setPrice(p.getPrice());
		session.update("Phone", a);
		session.getTransaction().commit();
		session.close();
		exit();
		return true;
	}
	public Phone HighestCharge() {
		List<Phone> list = getAll();
		int max = 0;
		Phone rs = null;
		for(Phone phone:list) {
			if(phone.getPrice() > max) {
				max = phone.getPrice();
				rs = phone;
			}
		}
		return rs;
	}
	public List<Phone> sortByName(){
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Phone> a=session.createCriteria(Phone.class).addOrder(Order.asc("Country")).addOrder(Order.asc("Price")).list();
		session.getTransaction().commit();
		session.close();
		exit();
		return a;
	}
	public boolean check50M() {
		List<Phone> list = getAll();
		for(Phone phone:list) {
			if(phone.getPrice()>50000000) {
				return true;
			}
		}
		return false;
	} 

	public Phone check() {
		List<Phone> list = getAll();
		for(Phone phone:list) {
			if(phone.getPrice()>15000000 && phone.getColor().equals("Pink")) {
				return phone;
			}
		}
		return null;
	}
	
}
