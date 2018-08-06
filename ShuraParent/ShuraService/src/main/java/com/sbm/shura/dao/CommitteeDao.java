package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.Committee;

public interface CommitteeDao extends GenericDao<Committee>{

	
	public Committee addCommittee(Committee c) throws RespositoryException;
	
	public List<Committee> listCommitees() throws RespositoryException;
	
//	public Committee findById(int id) throws RespositoryException;
}
