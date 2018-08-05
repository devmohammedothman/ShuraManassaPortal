package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.ResponseDTO;

public interface CommitteeManager {
	
	ResponseDTO addCommittee(CommitteeDTO obj) ;
	
	ResponseDTO getCommitteeList() ;
	
	ResponseDTO getCommitteeById(int id) ;
	
	ResponseDTO updateCommittee(CommitteeDTO obj) ;
	
	ResponseDTO deleteCommittee(int id) throws Exception;

}
