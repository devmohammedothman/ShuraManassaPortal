package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.PermissionDTO;

public interface PermissionService {

	PermissionDTO addPermission(PermissionDTO perm)  throws BusinessException;

	List<PermissionDTO> getPermList()  throws BusinessException;
	
	List<PermissionDTO> getPermListByMenu(long menuId)  throws BusinessException;

}
