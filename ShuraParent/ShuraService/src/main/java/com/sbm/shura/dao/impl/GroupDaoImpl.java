package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.shura.dao.GroupDao;
import com.sbm.shura.entity.Group;
import com.sbm.shura.entity.User;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao{

	@Override
	public Group add(Group group) throws Exception {
		return persist(group);
	}

	@Override
	public List<Group> getgroupList() throws Exception {
		return (List<Group>)entityManager.createNamedQuery("Group.findAll").getResultList();
	}

	@Override
	public Group getByEName(String name) throws Exception {
		// TODO Auto-generated method stub
			Query q = entityManager.createNamedQuery("Group.findByEName", Group.class);
			q.setParameter("name", name);
			Group groupObj = (Group) q.getSingleResult();
			return groupObj;
	}
	
}
