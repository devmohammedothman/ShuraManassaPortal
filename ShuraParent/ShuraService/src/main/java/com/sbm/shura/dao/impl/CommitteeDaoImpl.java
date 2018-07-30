package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.shura.dao.CommitteeDao;
import com.sbm.shura.entity.Committee;

@Repository
public class CommitteeDaoImpl extends GenericDaoImpl<Committee> implements CommitteeDao {

	@Override
	public Committee addCommittee(Committee c) {
		// TODO Auto-generated method stub
		return persist(c);
	}

	@Override
	public List<Committee> listCommitees() {
		// TODO Auto-generated method stub
		List<Committee> comList = entityManager.createNamedQuery("comm.findAll",Committee.class).getResultList();
		return comList;
	}

}
