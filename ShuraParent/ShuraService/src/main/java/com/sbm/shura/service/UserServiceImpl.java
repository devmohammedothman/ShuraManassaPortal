package com.sbm.shura.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.dao.UserDao;
import com.sbm.shura.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public User add(User user) {
		return userDao.add(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public User login(String email, String password) {
		User user = userDao.login(email, password);
		if (user == null) {
			return new User(-1L);
		}
		return user;
	}

}
