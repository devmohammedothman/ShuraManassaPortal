package com.sbm.shura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return em.createNamedQuery("User.findByEmailAndPassword", User.class).getSingleResult();
	}
	
	

}
