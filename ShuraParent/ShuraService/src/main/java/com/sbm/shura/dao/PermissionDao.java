package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.entity.Permission;

public interface PermissionDao extends GenericDao<Permission>{

	Permission add(Permission perm) throws Exception;

	List<Permission> getPermList() throws Exception;
}
