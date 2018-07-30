package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.UserDTO;

public interface UserService {
	
	UserDTO add(UserDTO user, String groupName);

	List<UserDTO> listUsers();

	UserDTO login(String email, String password);
	
	UserDTO findByEmail(String email);
	
	UserDTO assignGroupToUser(String groupName, String email) throws Exception;
	
	UserDTO findById(long userId);
}
