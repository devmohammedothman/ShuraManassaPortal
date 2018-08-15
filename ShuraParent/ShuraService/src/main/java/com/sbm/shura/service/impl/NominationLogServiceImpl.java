package com.sbm.shura.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.NominationLogDao;
import com.sbm.shura.dto.NominationLogDTO;
import com.sbm.shura.entity.NominationLog;
import com.sbm.shura.service.NominationLogService;

@Service
@Transactional
public class NominationLogServiceImpl extends BasicServiceImpl<NominationLogDTO, NominationLog> implements NominationLogService {

	
	@Autowired
	private NominationLogDao nominationDao;
	
	private NominationLog logEntity;
	
	@Override
	public NominationLogDTO addPOllLog(NominationLogDTO logObj) throws BusinessException {
		try {
			logEntity = new NominationLog();
			
			logEntity =  convertToEntity(logEntity, logObj);
			logEntity = nominationDao.addPOllLog(logEntity);
			logObj = convertToDTO(logEntity, logObj);
			
		}
		catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		
		return logObj;
	}

	@Override
	public NominationLogDTO updatePollLogApprovalStatus(long processId, boolean isApproved) throws BusinessException {
		
		NominationLogDTO logObj = null;
		try {
			
			logEntity = new NominationLog();
			
			logEntity =  nominationDao.findById(processId);
			logEntity.setApproved(isApproved);
			logEntity = nominationDao.update(logEntity);
			logObj = new NominationLogDTO();
			logObj = convertToDTO(logEntity, logObj);
			
		}
		catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		
		return logObj;
	}

}
