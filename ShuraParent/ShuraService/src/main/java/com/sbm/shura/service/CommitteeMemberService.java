package com.sbm.shura.service;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.CommitteeMemberDTO;

public interface CommitteeMemberService {
	
	CommitteeMemberDTO assignMemberToCommittee(CommitteeMemberDTO cmdto) throws BusinessException;

}
