package net.codejava.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManufactureDAO {
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
	public boolean add(Manufacture p) {
		setup();
		Session session = sessionFactory.openSession();
		try {
		session.beginTransaction();
		session.save(p);
		if(session.save(p)==null) {
			return false;
		}
		session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally
		{
		session.close();
		exit();
		}
		return true;
	}
	public Manufacture get(int id) {
		setup();
		Manufacture a=null;
		try {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		a = session.get(Manufacture.class, id);
		session.getTransaction().commit();
		session.close();
		return a;
		}catch(Exception e){
			e.printStackTrace();
		}
		exit();
		return null;
	}
	public List<Manufacture> getAll()
	{
		try {
			List<Manufacture> manufactures;
			setup();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			manufactures = session.createQuery("FROM Manufacture").list();
			
			
			if(manufactures.size() > 0)
			{
				return manufactures;
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
		try {
		session.beginTransaction();
		Manufacture a = new Manufacture();
		a = session.get(Manufacture.class, id);
		session.delete(a);
		session.getTransaction().commit();
		session.close();
		exit();
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean remove(Manufacture p) {
		setup();
		try {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Manufacture a = new Manufacture();
		session.delete(p);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			exit();
		}
		return false;
	}
	public boolean update(Manufacture p) {
		setup();
		try {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Manufacture a = session.get(Manufacture.class, p.getID());
		a.setEmployee(p.getEmployee());
		a.setLocation(p.getLocation());
		a.setName(p.getName());
		session.update("Phone", a);
		session.getTransaction().commit();
		session.close();
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			exit();
		}
		return false;
	}
	public boolean check100Employee() {
		List<Manufacture> a = getAll();
		for(Manufacture b:a) {
			if(b.getEmployee()<100) {
				return false;
			}
		}
		return true;
	}
	public int SumOfEmployee() {
		List<Manufacture> a = getAll();
		int s = 0;
		for(Manufacture b:a) {
			s += b.getEmployee();
		}
		return s;
	}
	public Manufacture lastUS()
	{
		setup();
		Manufacture a=null;
		try {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		if(session.createQuery("From Manufacture where Location = 'US' Order by ID DESC").list().size() != 0) {
				a = (Manufacture) session.createQuery("From Manufacture where Location = 'US' Order by ID DESC").list().get(0);
		}
		session.getTransaction().commit();
		session.close();
		return a;
		}catch(Exception e){
			e.printStackTrace();
		}
		exit();
		return null;
	}
}
