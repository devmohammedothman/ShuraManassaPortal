package com.sbm.shura.management;


import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.PermissionDTO;
import com.sbm.shura.dto.UserDTO;

public interface UserManagement {

	ResponseDTO createUser(UserDTO user, String groupName)  throws ControllerException;

	ResponseDTO getGroupList()  throws ControllerException;

	ResponseDTO add(GroupDTO group)  throws ControllerException;

	ResponseDTO getByEName(String name)  throws ControllerException;

	ResponseDTO addMenu(MenuDTO item)  throws ControllerException;

	ResponseDTO getMenuList()  throws ControllerException;

	ResponseDTO addPermission(PermissionDTO perm)  throws ControllerException;

	ResponseDTO getPermList()  throws ControllerException;

	ResponseDTO getPermListByMenu(long menuId)  throws ControllerException;

	ResponseDTO listUsers()  throws ControllerException;

	ResponseDTO login(String email, String password)  throws ControllerException;

	ResponseDTO findByEmail(String email)  throws ControllerException;

	ResponseDTO assignGroupToUser(String groupName, String email)  throws ControllerException;
	
	ResponseDTO findById(long userId)  throws ControllerException;

}
