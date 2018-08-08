package com.sbm.shura.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.CommitteeMemberDao;
import com.sbm.shura.dto.CommitteeMemberDTO;
import com.sbm.shura.entity.CommitteeMember;
import com.sbm.shura.service.CommitteeMemberService;

@Service
@Transactional
public class CommitteeMemberServiceImpl extends BasicServiceImpl<CommitteeMemberDTO, CommitteeMember> implements CommitteeMemberService{

	@Autowired
	private CommitteeMemberDao _comDao;
	
	private CommitteeMember _commMember;
	
	@Override
	public CommitteeMemberDTO assignMemberToCommittee(CommitteeMemberDTO cmdto) throws BusinessException {
		CommitteeMemberDTO cmdtoResult = null;
		try {
			_commMember = new CommitteeMember();
			
			_commMember = convertToEntity(_commMember, cmdto);
			
			_commMember = _comDao.addCommMember(_commMember);
			cmdtoResult = convertToDTO(_commMember, cmdto);
			
		}
		catch(RespositoryException re)
		{
			re.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return cmdtoResult;
	}

	@Override
	public void deleteCommitteeAssignedMembers(long commId) throws BusinessException {
		
		try 
		{	
			_comDao.delete(commId);
		}
		catch(RespositoryException re)
		{
		re.printStackTrace();
		throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch (Exception e) {
		e.printStackTrace();
		throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
	}

	@Override
	public List<CommitteeMemberDTO> getCommitteeAssignedMembers(long commId) throws BusinessException {
		List<CommitteeMemberDTO> resultList = null;
		try 
		{
			List<CommitteeMember> entityResulList = new ArrayList<>();
			entityResulList = _comDao.getCommitteeAssignedMembers(commId);
			resultList = entityResulList.stream().map(item -> convertToDTO(item, new CommitteeMemberDTO())).collect(Collectors.toList());
		}
		catch(RespositoryException re)
		{
			re.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return resultList;
	}

}