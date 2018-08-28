package com.sbm.shura.management;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.commonlib.dtoresponsehandler.*;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;

public interface CommitteeManager {
	
	ResponseDTO addCommittee(CommitteeDTO obj)  throws ControllerException;
	
	ResponseDTO getCommitteeList() throws ControllerException;
	
	ResponseDTO getCommitteeById(int id)  throws ControllerException;
	
	ResponseDTO updateCommittee(CommitteeDTO obj)  throws ControllerException;
	
	ResponseDTO deleteCommittee(int id)  throws ControllerException;
	
}
