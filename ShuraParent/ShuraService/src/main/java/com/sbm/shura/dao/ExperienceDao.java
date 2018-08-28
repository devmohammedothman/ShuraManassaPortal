package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.Experience;

public interface ExperienceDao extends GenericDao<Experience>
{

	Experience addExperience(Experience experience) throws RespositoryException;
	
	Experience getExperienceByName(String name) throws RespositoryException;

	List<Experience> getExperiencesList() throws RespositoryException;
}
