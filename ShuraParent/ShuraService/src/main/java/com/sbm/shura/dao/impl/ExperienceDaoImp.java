package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.ExperienceDao;
import com.sbm.shura.entity.Experience;

@Repository
public class ExperienceDaoImp extends GenericDaoImpl<Experience> implements ExperienceDao{

	@Override
	public Experience addExperience(Experience experience) throws RespositoryException {
		Experience experienceResult = null;
		try {
			experienceResult = persist(experience);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return experienceResult;
	}

	@Override
	public List<Experience> getExperiencesList() throws RespositoryException {
		List<Experience> experiences;
		try {
			TypedQuery<Experience> query = entityManager.createNamedQuery("Experience.findAll", Experience.class);
			experiences = query.getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return experiences;
	}

	@Override
	public Experience getExperienceByName(String name) throws RespositoryException {
		Experience experience = null;
		try {
			Query q = entityManager.createNamedQuery("Experience.findByNameEn", Experience.class);
			q.setParameter("nameEn", name);
			experience = (Experience) q.getSingleResult();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return experience;
	}
	
}
