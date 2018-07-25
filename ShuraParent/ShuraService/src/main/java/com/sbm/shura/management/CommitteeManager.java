package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.dto.CommitteeDTO;

public interface CommitteeManager {
	
	CommitteeDTO addCommittee(CommitteeDTO obj) ;
	
	List<CommitteeDTO> getCommitteeList() ;
	
	CommitteeDTO getCommitteeById(int id) ;
	
	CommitteeDTO updateCommittee(CommitteeDTO obj) ;
	
	void deleteCommittee(int id) throws Exception;

}
