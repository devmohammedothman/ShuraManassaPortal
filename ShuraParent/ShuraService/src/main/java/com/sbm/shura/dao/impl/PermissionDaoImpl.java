package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.PermissionDao;
import com.sbm.shura.entity.Permission;

@Repository
public class PermissionDaoImpl extends GenericDaoImpl<Permission> implements PermissionDao {

	@Override
	public Permission add(Permission perm) throws RespositoryException {
		Permission permission = null;
		try {
			permission = persist(perm);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return permission;
	}

	@Override
	public List<Permission> getPermList() throws RespositoryException {
		List<Permission> permissions;
		try {
		permissions = (List<Permission>)entityManager.createNamedQuery("Permission.findAll", Permission.class).getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return permissions;
	}

	@Override
	public List<Permission> getPermListByMenu(long menuId) throws RespositoryException {
		List<Permission> permissions;
		try {
		TypedQuery<Permission> q = entityManager.createNamedQuery("Permission.findByMenu", Permission.class);
		q.setParameter("menuId", menuId);
		permissions = q.getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return permissions;
	}

}
