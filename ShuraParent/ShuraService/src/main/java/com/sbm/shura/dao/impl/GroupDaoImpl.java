package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.GroupDao;
import com.sbm.shura.entity.Group;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao{

	@Override
	public Group add(Group group) throws RespositoryException {
		Group groupResult = null;
		try {
		groupResult = persist(group);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return groupResult;
	}

	@Override
	public List<Group> getgroupList() throws RespositoryException {
		List<Group> groups;
		try {
			TypedQuery<Group> query = entityManager.createNamedQuery("Group.findAll", Group.class);
			groups = query.getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return groups;
	}

	@Override
	public Group getByEName(String name) throws RespositoryException {
		Group group = null;
		try {
			Query q = entityManager.createNamedQuery("Group.findByEName", Group.class);
			q.setParameter("name", name);
			group = (Group) q.getSingleResult();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return group;
	}
	
}
