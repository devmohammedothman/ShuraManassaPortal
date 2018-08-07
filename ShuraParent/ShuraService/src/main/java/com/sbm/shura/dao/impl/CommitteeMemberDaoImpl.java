package com.sbm.shura.dao.impl;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.CommitteeMemberDao;
import com.sbm.shura.entity.CommitteeMember;

@Repository
public class CommitteeMemberDaoImpl extends GenericDaoImpl<CommitteeMember>  implements CommitteeMemberDao {

	@Override
	public CommitteeMember addCommMember(CommitteeMember cmObj) throws RespositoryException {
		
		CommitteeMember commMemberObjResult = null;
		try 
		{
			commMemberObjResult = persist(cmObj);
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return commMemberObjResult;
	}

}
