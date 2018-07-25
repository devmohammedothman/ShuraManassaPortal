package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.PermissionDTO;
import com.sbm.shura.dto.UserDTO;

public interface UserManagement {

	UserDTO createUser(UserDTO user, String groupName);

	List<GroupDTO> getGroupList() throws Exception;

	GroupDTO add(GroupDTO group) throws Exception;

	GroupDTO getByEName(String name) throws Exception;

	MenuDTO addMenu(MenuDTO item) throws Exception;

	List<MenuDTO> getMenuList() throws Exception;

	PermissionDTO addPermission(PermissionDTO perm) throws Exception;

	List<PermissionDTO> getPermList() throws Exception;

	List<PermissionDTO> getPermListByMenu(long menuId) throws Exception;

	List<UserDTO> listUsers();

	UserDTO login(String email, String password);

	UserDTO findByEmail(String email);

	UserDTO assignGroupToUser(String groupName, String email) throws Exception;

}
