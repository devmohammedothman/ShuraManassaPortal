package com.sbm.shura.dao.impl;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.NominationLogDao;
import com.sbm.shura.entity.NominationLog;

@Repository
public class NominationLogDaoImpl extends GenericDaoImpl<NominationLog> implements NominationLogDao {

	@Override
	public NominationLog addPOllLog(NominationLog obj) throws RespositoryException {
		
	NominationLog logObj  = null; 
	
		try 
		{
			logObj = persist(obj);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return logObj;
	}


}
