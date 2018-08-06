package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.UserDTO;

public interface UserService {
	
	UserDTO add(UserDTO user, String groupName) throws BusinessException;

	List<UserDTO> listUsers() throws BusinessException;

	UserDTO login(String email, String password) throws BusinessException;
	
	UserDTO findByEmail(String email) throws BusinessException;
	
	UserDTO assignGroupToUser(String groupName, String email)  throws BusinessException;
	
	UserDTO findById(long userId) throws BusinessException;
}
