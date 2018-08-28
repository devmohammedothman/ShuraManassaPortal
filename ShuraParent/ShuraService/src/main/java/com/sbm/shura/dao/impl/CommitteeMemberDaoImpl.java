package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

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

	@Override
	public List<CommitteeMember> getCommitteeAssignedMembers(long commId) throws RespositoryException {
		List<CommitteeMember> resultList = null;
		try 
		{
			Query q = entityManager.createNamedQuery("commMember.getCommAssignedMembers",CommitteeMember.class);
			q.setParameter("commId", commId);
			resultList = (q.getResultList() != null && q.getResultList().size() > 0 ? q.getResultList() : null);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return resultList;
	}

	@Override
	public void deleteCommitteeAssignedMembers(long commId) throws RespositoryException {
		
		try {
				Query q = entityManager.createNamedQuery("commMember.deleteCommAssignedMembers");
				q.setParameter("commId", commId);
			
				q.executeUpdate();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
			}
		
	}

	@Override
	public List<CommitteeMember> getAllCommitteeCurrentMember() throws RespositoryException {
		
		List<CommitteeMember> resultList = null;
		try 
		{
			resultList = entityManager.createNamedQuery("commMember.findAll",CommitteeMember.class).getResultList();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return resultList;
	}

	@Override
	public CommitteeMember getCommitteeMemberByUserId(long userid) throws RespositoryException {
		CommitteeMember commMemberObjResult = null;
		try {
			
			Query q = entityManager.createNamedQuery("commMember.findByUserId",CommitteeMember.class);
			q.setParameter("userid", userid);
			commMemberObjResult = (CommitteeMember)q.getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return commMemberObjResult;
	}

	@Override
	public void deleteAllCommitteeAssignedMembers() throws RespositoryException {
		try {
			entityManager.createNamedQuery("commMember.deleteAllCommAssignedMembers").executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
	
	}

}
