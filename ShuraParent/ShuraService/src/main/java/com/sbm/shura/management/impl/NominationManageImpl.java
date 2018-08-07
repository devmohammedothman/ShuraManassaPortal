package com.sbm.shura.management.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.commonlib.utilities.HijriDateConverter;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.NominationLogDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;
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
	public ResponseDTO getUserWishList() {
		ResponseDTO responseDTO = null;
		// try {
		// responseDTO = new ResponseDTO("Shura.business.code.1000", "successfully",
		// "successfully",
		// null);
		// }catch(BusinessException e) {
		// e.printStackTrace();
		// throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
		// }
		// catch(Exception e1) {
		// e1.printStackTrace();
		// throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		// }
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
		String result;
		try {

			// first step in selection process algorithm
			// get all user wishes in current shurain year
			String currentHijriiDate = Integer.toString(HijriDateConverter.convertCurrentDateToHijri().getYear());
			List<UserWishDTO> userWishes = _userWishService.getCurrentHijriiYearUserWishList(currentHijriiDate);

			List<CommitteeDTO> commDTOList = _committeeService.getCommitteeList();
			List<UserWishDTO> filteredUserWishList = new ArrayList<UserWishDTO>();
			for (CommitteeDTO item : commDTOList) {
				filteredUserWishList = userWishes.stream().filter(
						uwitem -> item.getId() == uwitem.getWishedCommitee().getId() && uwitem.getWishOrder() == 1)
						.collect(Collectors.toList());

				// call random generation process and add to List
				if (filteredUserWishList.size() > logDtoObj.getNoOfMembers()) {
					List<Integer> intList = new ArrayList<>();
					for (int i = 0; i < filteredUserWishList.size(); i++) {
						intList.add(i);
					}
					filteredUserWishList = selectedUserList(intList, filteredUserWishList);
				}
			}

			result = "Process Run Successfully";
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

	public List<Integer> givenList_w(List<Integer> list) {
		Collections.shuffle(list);
		int randomSeriesLength = 5;
		return list.subList(0, randomSeriesLength);
	}

	public List<UserWishDTO> selectedUserList(List<Integer> list, List<UserWishDTO> userList) {
		List<Integer> selectedUsersIndex = givenList_w(list);
		List<UserWishDTO> selectedUserList = new ArrayList<>();
		for (int i = 0; i < selectedUsersIndex.size(); i++) {
			selectedUserList.add(userList.get(selectedUsersIndex.get(i)));
		}
		return selectedUserList;
	}

}
