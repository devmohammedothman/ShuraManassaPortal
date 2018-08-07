package com.sbm.shura.dao;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.NominationLog;

public interface NominationLogDao extends GenericDao<NominationLog> {

	
	NominationLog addPOllLog(NominationLog obj) throws RespositoryException;;
}
