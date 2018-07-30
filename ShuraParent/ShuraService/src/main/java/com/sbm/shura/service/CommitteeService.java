package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.CommitteeDTO;

public interface CommitteeService {
	
	CommitteeDTO addCommittee(CommitteeDTO obj) throws Exception;
	
	List<CommitteeDTO> getCommitteeList() throws Exception;
	
	CommitteeDTO getCommitteeById(int id) throws Exception;
	
	CommitteeDTO updateCommittee(CommitteeDTO obj) throws Exception;
	
	void deleteCommittee(int id) throws Exception;
	
	CommitteeDTO findById(long committeeId);

}
