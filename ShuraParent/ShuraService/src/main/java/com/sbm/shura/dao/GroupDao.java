package com.sbm.shura.dao;

import java.util.List;

import  com.sbm.shura.entity.Group;

public interface GroupDao extends GenericDao<Group>
{

	Group add(Group group) throws Exception;
	
	Group getByEName(String name) throws Exception;

	List<Group> getgroupList() throws Exception;
}
