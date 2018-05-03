package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.entity.User;

public interface UserService {
	User add(User user);

	List<User> listUsers();

	User login(String email, String password);
}
