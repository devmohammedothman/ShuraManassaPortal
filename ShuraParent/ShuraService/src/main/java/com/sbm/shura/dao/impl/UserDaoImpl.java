package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.sbm.shura.dao.UserDao;
import com.sbm.shura.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User>  implements UserDao{


	@Override
	public User add(User user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	public List<User> listUsers() {
		return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
	}

	@Override
	public User login(String email, String password) {
		try {
			Query q = entityManager.createNamedQuery("User.findByEmailAndPassword", User.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			return (User) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
