package com.sbm.shura.management.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.commonlib.utilities.HijriDateConverter;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.CommitteeMemberDTO;
import com.sbm.shura.dto.ExperienceDTO;
import com.sbm.shura.dto.NominationLogDTO;
import com.sbm.shura.dto.PollProcessResultDto;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;
import com.sbm.shura.service.CommitteeMemberService;
import com.sbm.shura.service.CommitteeService;
import com.sbm.shura.service.NominationLogService;
import com.sbm.shura.service.UserWishService;

@Component
public class NominationManageImpl implements NominationManage {

	@Autowired
	private UserWishService _userWishService;

	@Autowired
	private NominationLogService _nominationService;

	@Autowired
	private CommitteeService _committeeService;
	
	@Autowired
	private CommitteeMemberService _commMemberService;

	@Override
	public ResponseDTO addUserWish(List<UserWishDTO> list) throws ControllerException {
		ResponseDTO responseDTO = null;
		String result = "";
		try {
			UserWishDTO wishObj = _userWishService
					.getUserWishesByUserIdAndCommitte(list.get(0).getNominatedUser().getUserId());
			if (wishObj == null) {
				for (int i = 0; i < list.size(); i++) {
					_userWishService.addUserWish(list.get(i));
				}
				result = "Done Added New";
			} else {
				_userWishService.deleteWish(list.get(0).getNominatedUser().getUserId());
				for (int i = 0; i < list.size(); i++) {
					_userWishService.addUserWish(list.get(i));
				}
				result = "Done Updated";
			}
			responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", result);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}


	@Override
	public ResponseDTO getUserWishesByUserIdAndCommitte(long userId) throws ControllerException {

		ResponseDTO responseDTO = null;
		try {
			UserWishDTO userWishDTO = _userWishService.getUserWishesByUserIdAndCommitte(userId);
			responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", userWishDTO);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO managerAssignUserWish(List<UserWishDTO> list) throws ControllerException {
		ResponseDTO responseDTO = null;
		String result = "";
		try {
			UserWishDTO wishObj = _userWishService
					.getUserWishesByUserIdAndCommitte(list.get(0).getNominatedUser().getUserId());
			if (wishObj == null) {
				for (int i = 0; i < list.size(); i++) {
					_userWishService.addUserWish(list.get(i));
				}
				result = "Done Added New";
			} else {
				_userWishService.deleteWish(list.get(0).getNominatedUser().getUserId());
				for (int i = 0; i < list.size(); i++) {
					_userWishService.addUserWish(list.get(i));
				}
				result = "Done Updated";
			}
			responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", result);
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO addPOllLog(NominationLogDTO logDtoObj) throws ControllerException {
		ResponseDTO responseDTO = null;

		try {
			NominationLogDTO logDtoResult = _nominationService.addPOllLog(logDtoObj);

			responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", logDtoResult);

		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO runPollProcess(NominationLogDTO logDtoObj) throws ControllerException {
		ResponseDTO responseDTO = null;
		
		try {
			int memberCount = logDtoObj.getNoOfMembers();
			if(memberCount == 0 || memberCount < 0 )
				throw new ControllerException(ExceptionEnums.INVALID_OPERATION);
			
			// first step in selection process algorithm
			// get all user wishes in current shurain year
			String currentHijriiDate = Integer.toString(HijriDateConverter.convertCurrentDateToHijri().getYear());
			List<UserWishDTO> userWishes = _userWishService.getCurrentHijriiYearUserWishList(currentHijriiDate);
		
			//check of user wish list is empty to return
			if(userWishes!= null &&  userWishes.size() == 0)
			{
				responseDTO = new ResponseDTO("Shura.business.code.1000", "No User Wishes Found", "لم يتم إضافة رغبات من الأعضاء","");
				return responseDTO;
			}

			List<CommitteeDTO> commDTOList = _committeeService.getCommitteeList();
			List<CommitteeMemberDTO> commMemberResultList =  new ArrayList<>(); 
			
			
			List<UserWishDTO> firstUserWishList = new ArrayList<UserWishDTO>();
			List<UserWishDTO> secondUserWishList = new ArrayList<UserWishDTO>();
			List<UserWishDTO> thirdUserWishList = new ArrayList<UserWishDTO>();
			
			//Lists without experience
			List<UserWishDTO> firstWishList = new ArrayList<UserWishDTO>();
			
			for(CommitteeDTO item : commDTOList)
			{			
				if(userWishes.size() == 0)
					break;
				
				List<CommitteeMemberDTO> commTempList = new ArrayList<>();
				int remainingMembersCount ;

				//all members who have current committee as first wish and experience applicable
				firstUserWishList = userWishes.stream().filter(
						uwitem -> uwitem.getWishOrder() == 1 && uwitem.getWishedCommitee().getId().equals(item.getId())
                        && (!uwitem.getNominatedUser().getExpList().listIterator().next().equals("")
                        		&& uwitem.getNominatedUser().getExpList().listIterator().next().equals(
                        				item.getExpList().listIterator().next()))
						).collect(Collectors.toList());
				
				if (firstUserWishList.size() < memberCount) {
					firstWishList = userWishes.stream().filter(
							uwitem -> uwitem.getWishOrder() == 1 && uwitem.getWishedCommitee().getId().equals(item.getId())
							).collect(Collectors.toList());
					firstWishList.removeAll(firstUserWishList);
					firstUserWishList.addAll(firstWishList);
				}
				
				
				//all members who have current committee as  second wish
				secondUserWishList = userWishes.stream().filter(
						uwitem -> uwitem.getWishOrder() == 2 && uwitem.getWishedCommitee().getId().equals(item.getId())
						).collect(Collectors.toList());
				
				
				//all members who have current committee as  third wish
								thirdUserWishList = userWishes.stream().filter(
										uwitem -> uwitem.getWishOrder() == 3 && uwitem.getWishedCommitee().getId().equals(item.getId())
										).collect(Collectors.toList());
				
				// call random generation process and add to List
				if (firstUserWishList.size() > memberCount) 
				{
					List<Integer> intList = new ArrayList<>();
					for (int i = 0; i < firstUserWishList.size(); i++) {
						intList.add(i);
					}
					firstUserWishList = selectedUserList(intList, firstUserWishList,memberCount);
				}
				
				//add selected users to main committee members list
				if(firstUserWishList.size() > 0 )
				{
					commTempList.addAll(firstUserWishList.stream().map(commMember ->
					new CommitteeMemberDTO(commMember.getNominatedUser(),commMember.getWishedCommitee(),commMember.getWishOrder(), false))
					.collect(Collectors.toList()));
					
					//remove selected user from user wish list to not be chosen again
					for(int index = 0 ; index < firstUserWishList.size();index ++)
					{
						UserWishDTO uwDtoRemovedObject = firstUserWishList.get(index);
						userWishes.removeIf(it -> it.getNominatedUser().getUserId() == uwDtoRemovedObject.getNominatedUser().getUserId());
					}
				}
					//this condition to indicate that i still have places on this committee
					if(commTempList.size() < memberCount)
					{
						remainingMembersCount = memberCount - commTempList.size() ;
						
						if(remainingMembersCount > 0 && !secondUserWishList.isEmpty() && secondUserWishList.size() > 0)
						{
							List<Integer> intList = new ArrayList<>();
							for (int i = 0; i < secondUserWishList.size(); i++) {
								intList.add(i);
							}
							secondUserWishList = selectedUserList(intList, secondUserWishList,remainingMembersCount);
							commTempList.addAll(secondUserWishList.stream().map(commMember ->
							new CommitteeMemberDTO(commMember.getNominatedUser(),commMember.getWishedCommitee(),commMember.getWishOrder(), false))
							.collect(Collectors.toList()));
							
							//remove selected user from user wish list to not be chosen again
							for(int index = 0 ; index < secondUserWishList.size();index ++)
							{
								UserWishDTO uwDtoRemovedObject = secondUserWishList.get(index);
								userWishes.removeIf(it -> it.getNominatedUser().getUserId() == uwDtoRemovedObject.getNominatedUser().getUserId());
							}
						}

						remainingMembersCount = memberCount - commTempList.size() ;
		
						if(remainingMembersCount > 0 && !thirdUserWishList.isEmpty() && thirdUserWishList.size() > 0)
						{
							List<Integer> intList = new ArrayList<>();
							for (int i = 0; i < secondUserWishList.size(); i++) {
								intList.add(i);
							}
							thirdUserWishList = selectedUserList(intList, thirdUserWishList,remainingMembersCount);
							commTempList.addAll(thirdUserWishList.stream().map(commMember ->
							new CommitteeMemberDTO(commMember.getNominatedUser(),commMember.getWishedCommitee(),commMember.getWishOrder(), false))
							.collect(Collectors.toList()));
							
							//remove selected user from user wish list to not be chosen again
							for(int index = 0 ; index < secondUserWishList.size();index ++)
							{
								UserWishDTO uwDtoRemovedObject = secondUserWishList.get(index);
								userWishes.removeIf(it -> it.getNominatedUser().getUserId() == uwDtoRemovedObject.getNominatedUser().getUserId());
							}
						}
						
					}
					remainingMembersCount = memberCount - commTempList.size() ;
					
					commMemberResultList.addAll(commTempList);
				}
			
		//Add Log to Nomination Log
		logDtoObj = _nominationService.addPOllLog(logDtoObj);
		
		PollProcessResultDto result = new PollProcessResultDto();
		
		result.setCommitteeMembers(commMemberResultList);
		result.setProcessId(logDtoObj.getId());
		confirmPollResult(result, false);
		responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", result);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}

	public List<Integer> givenList_w(List<Integer> list , int noOfMembers) {
		Collections.shuffle(list);
		if (noOfMembers > list.size())
			return list;
		return list.subList(0, noOfMembers);
	}

	public List<UserWishDTO> selectedUserList(List<Integer> list, List<UserWishDTO> userList,int noOfMembers) {
		List<Integer> selectedUsersIndex = givenList_w(list,noOfMembers);
		List<UserWishDTO> selectedUserList = new ArrayList<>();
		for (int i = 0; i < selectedUsersIndex.size(); i++) {
			selectedUserList.add(userList.get(selectedUsersIndex.get(i)));
		}
		return selectedUserList;
	}


	@Override
	public ResponseDTO confirmPollResult(PollProcessResultDto approvedList, boolean isApproved) throws ControllerException {
		ResponseDTO responseDTO = null;
		
		try 
		{
			for(CommitteeMemberDTO memDtoItem : approvedList.getCommitteeMembers())
			{

				List<CommitteeMemberDTO> assignedCommList = _commMemberService.getCommitteeAssignedMembers(memDtoItem.getCommittee().getId());
				if(assignedCommList != null && assignedCommList.size() > 0)
				{
					//delete assigned members to each committee
					_commMemberService.deleteCommitteeAssignedMembers(memDtoItem.getCommittee().getId());
				}
			}
			//assign member to Committee
			for(CommitteeMemberDTO memDtoItem : approvedList.getCommitteeMembers())
			{
				memDtoItem.setApproved(isApproved);
				_commMemberService.assignMemberToCommittee(memDtoItem);
			}
			
		  _nominationService.updatePollLogApprovalStatus(approvedList.getProcessId(), isApproved);
			
		responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", approvedList);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}


	@Override
	public ResponseDTO getCommitteeAssignedMembers(long commId) throws ControllerException {
		ResponseDTO responseDTO = null;
		try {
			responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					_commMemberService.getCommitteeAssignedMembers(commId));
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}


	@Override
	public ResponseDTO getAllCommitteeCurrentMember() throws ControllerException {
		ResponseDTO responseDTO = null;
		try {
			responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					_commMemberService.getAllCommitteeCurrentMember());
		} 
		catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}


	@Override
	public ResponseDTO updateMemberAssignedCommittee(CommitteeMemberDTO commMemberDto) throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try 
		{
			
			CommitteeMemberDTO resultObj = _commMemberService.updateMemberAssignedCommittee(commMemberDto);
			if(resultObj != null)
				responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully", "successfully", resultObj);
		}
		catch (BusinessException e) {
			e.printStackTrace();
			throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION, e1);
		}
		return responseDTO;
	}

}
