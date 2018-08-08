package com.sbm.shura.service;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.NominationLogDTO;

public interface NominationLogService {
	
	NominationLogDTO addPOllLog(NominationLogDTO logObj)  throws BusinessException;
	
	NominationLogDTO updatePollLogApprovalStatus(long processId) throws BusinessException;

}
