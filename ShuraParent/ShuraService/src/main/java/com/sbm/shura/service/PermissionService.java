package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.PermissionDTO;

public interface PermissionService {

	PermissionDTO addPermission(PermissionDTO perm) throws Exception;

	List<PermissionDTO> getPermList() throws Exception;
	
	List<PermissionDTO> getPermListByMenu(long menuId) throws Exception;

}
