package com.sbm.shura.dao;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.CommitteeMember;

public interface CommitteeMemberDao extends GenericDao<CommitteeMember> {

	
	CommitteeMember addCommMember(CommitteeMember commMemberObj) throws RespositoryException;
}
