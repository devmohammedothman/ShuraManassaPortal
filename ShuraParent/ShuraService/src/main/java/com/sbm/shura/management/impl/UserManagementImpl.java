package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.PermissionDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.management.UserManagement;
import com.sbm.shura.service.GroupService;
import com.sbm.shura.service.MenuService;
import com.sbm.shura.service.PermissionService;
import com.sbm.shura.service.UserService;

@Component
public class UserManagementImpl implements UserManagement {

	@Autowired
	private UserService userService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private PermissionService permSerivce;

	@Autowired
	private MenuService menuService;

	@Override
	public UserDTO createUser(UserDTO user, String groupName) {
		return userService.add(user, groupName);
	}

	@Override
	public GroupDTO add(GroupDTO group) throws Exception {
		return groupService.add(group);
	}

	@Override
	public GroupDTO getByEName(String name) throws Exception {
		return groupService.getByEName(name);
	}

	@Override
	public List<GroupDTO> getGroupList() throws Exception {
		return groupService.getgroupList();
	}

	@Override
	public MenuDTO addMenu(MenuDTO item) throws Exception {
		return menuService.addMenu(item);
	}

	@Override
	public List<MenuDTO> getMenuList() throws Exception {
		return menuService.getMenuList();
	}

	@Override
	public PermissionDTO addPermission(PermissionDTO perm) throws Exception {
		return permSerivce.addPermission(perm);
	}

	@Override
	public List<PermissionDTO> getPermList() throws Exception {
		return permSerivce.getPermList();
	}

	@Override
	public List<PermissionDTO> getPermListByMenu(long menuId) throws Exception {
		return permSerivce.getPermListByMenu(menuId);
	}

	@Override
	public List<UserDTO> listUsers() {
		return userService.listUsers();
	}

	@Override
	public UserDTO login(String email, String password) {
		return userService.login(email, password);
	}

	@Override
	public UserDTO findByEmail(String email) {
		return userService.findByEmail(email);
	}

	@Override
	public UserDTO assignGroupToUser(String groupName, String email) throws Exception {
		return userService.assignGroupToUser(groupName, email);
	}

}
