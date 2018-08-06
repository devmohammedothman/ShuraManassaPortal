package com.sbm.shura.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.CommitteeDao;
import com.sbm.shura.entity.Committee;

@Repository
public class CommitteeDaoImpl extends GenericDaoImpl<Committee> implements CommitteeDao {

	@Override
	public Committee addCommittee(Committee c) throws RespositoryException {
		Committee committee = null;
		try {
		committee = persist(c);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return committee;
	}

	@Override
	public List<Committee> listCommitees() throws RespositoryException {
		List<Committee> comList;
		try {
		comList = entityManager.createNamedQuery("comm.findAll",Committee.class).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return comList;
	}

}
