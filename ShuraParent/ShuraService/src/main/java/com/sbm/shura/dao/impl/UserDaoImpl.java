package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.UserDao;
import com.sbm.shura.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User>  implements UserDao{


	@Override
	public User add(User user) throws RespositoryException {
		User userResult = null;
		try {
		userResult = persist(user);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return userResult;
	}

	@Override
	public List<User> listUsers() throws RespositoryException {
		List<User> users;
		try {
		users =  entityManager.createNamedQuery("User.findAll", User.class).getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		
		return users;
	}

	@Override
	public User login(String email, String password) throws RespositoryException {
		User user = null;
		try {
			Query q = entityManager.createNamedQuery("User.findByEmailAndPassword", User.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			user = (User) q.getSingleResult();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return user;
		
	}
	
	@Override
	public User findByEmail(String email) throws RespositoryException {
		User userObj = null;
		try {
			Query q = entityManager.createNamedQuery("User.findByEmail", User.class);
			q.setParameter("email", email);
			userObj = (User) q.getSingleResult();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return userObj;
	}

	@Override
	public User updateUser(User user) throws RespositoryException {
		User userResult;
		try {
		userResult = update(user);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return userResult;
	}


}
