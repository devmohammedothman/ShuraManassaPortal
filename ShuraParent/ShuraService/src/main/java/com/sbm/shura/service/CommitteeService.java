package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.CommitteeDTO;

public interface CommitteeService {
	
	CommitteeDTO addCommittee(CommitteeDTO obj) throws BusinessException;
	
	List<CommitteeDTO> getCommitteeList() throws BusinessException;
	
	CommitteeDTO getCommitteeById(int id) throws BusinessException;
	
	CommitteeDTO updateCommittee(CommitteeDTO obj) throws BusinessException;
	
	void deleteCommittee(int id) throws BusinessException;
	
	CommitteeDTO findById(long committeeId) throws BusinessException;

}
