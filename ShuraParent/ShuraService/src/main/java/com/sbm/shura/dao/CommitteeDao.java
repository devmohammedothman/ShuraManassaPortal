package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.entity.Committee;

public interface CommitteeDao extends GenericDao<Committee>{

	
	public Committee addCommittee(Committee c);
	
	public List<Committee> listCommitees();
	
//	public Committee findById(int id);
}
