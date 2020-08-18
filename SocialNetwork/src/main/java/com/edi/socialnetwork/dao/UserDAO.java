package com.edi.socialnetwork.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import com.edi.socialnetwork.model.User;

public class UserDAO {
	private SessionFactory factory;
	private Session session;
	
	public UserDAO(){
		
		factory = new Configuration().configure()
				
				.buildSessionFactory();
		session=factory.openSession();
	}
	
	public void insertUser(User user){
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public List<User> getUserByName(String name){
		List query=session.
				createQuery("From User where name  =:x").
				setParameter("x", name).
				list();
		
		return query;
	}
	
	public void update(User user){
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	public void close(){
		session.close();
		factory.close();
	}
	
	
}
