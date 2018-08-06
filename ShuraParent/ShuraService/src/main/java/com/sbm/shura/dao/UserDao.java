package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.User;

public interface UserDao extends GenericDao<User> {

	User add(User user) throws RespositoryException;

	List<User> listUsers() throws RespositoryException;
	
	User login(String email, String password) throws RespositoryException;
	
	User findByEmail(String email) throws RespositoryException;

	User updateUser(User user) throws RespositoryException;
}
