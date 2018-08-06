package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.Permission;

public interface PermissionDao extends GenericDao<Permission>{

	Permission add(Permission perm) throws RespositoryException;

	List<Permission> getPermList() throws RespositoryException;
	
	List<Permission> getPermListByMenu(long menuId) throws RespositoryException;
}
