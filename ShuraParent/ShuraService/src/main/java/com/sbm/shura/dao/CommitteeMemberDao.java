package com.sbm.shura.dao;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.CommitteeMember;
import java.util.List;

public interface CommitteeMemberDao extends GenericDao<CommitteeMember> {

	
	CommitteeMember addCommMember(CommitteeMember commMemberObj) throws RespositoryException;
	
	List<CommitteeMember> getCommitteeAssignedMembers(long commId) throws RespositoryException;
	
	void deleteCommitteeAssignedMembers(long commId) throws RespositoryException;
}
