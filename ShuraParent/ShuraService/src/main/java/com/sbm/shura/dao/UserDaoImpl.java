package com.sbm.shura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.shura.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public User add(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public List<User> listUsers() {
		return em.createNamedQuery("User.findAll", User.class).getResultList();
	}

	@Override
	public User login(String email, String password) {
		try {
			Query q = em.createNamedQuery("User.findByEmailAndPassword", User.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			return (User) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
