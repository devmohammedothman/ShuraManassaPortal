package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import  com.sbm.shura.entity.Group;

public interface GroupDao extends GenericDao<Group>
{

	Group add(Group group) throws RespositoryException;
	
	Group getByEName(String name) throws RespositoryException;

	List<Group> getgroupList() throws RespositoryException;
}
