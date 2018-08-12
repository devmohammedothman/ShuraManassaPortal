package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.CommitteeMemberDTO;

public interface CommitteeMemberService {
	
	CommitteeMemberDTO assignMemberToCommittee(CommitteeMemberDTO cmdto) throws BusinessException;
	
	void deleteCommitteeAssignedMembers(long commId) throws BusinessException;
	
	List<CommitteeMemberDTO> getCommitteeAssignedMembers(long commId) throws BusinessException;
	
	List<CommitteeMemberDTO> getAllCommitteeCurrentMember() throws BusinessException;
	
	CommitteeMemberDTO updateMemberAssignedCommittee(CommitteeMemberDTO commMemberDto) throws BusinessException;

}
