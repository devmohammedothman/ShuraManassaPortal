package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;
import com.sbm.shura.service.UserWishService;

@Component
public class NominationManageImpl implements NominationManage {

	@Autowired
	private UserWishService _userWishService;
		
	@Override
	public ResponseDTO addUserWish(List<UserWishDTO> list) throws ControllerException {
		ResponseDTO responseDTO = null;
		String result = "";
		try {
		UserWishDTO wishObj = _userWishService.getUserWishesByUserIdAndCommitte(list.get(0).getNominatedUser().getUserId());
		if (wishObj.getId().equals(-1L)) {
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
		responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
				result);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}
	
	@Override
	public ResponseDTO getUserWishList() {
		ResponseDTO responseDTO = null;
//		try {
//			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
//					null);
//		}catch(BusinessException e) {
//			 e.printStackTrace();
//			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
//			}
//		 catch(Exception e1) {
//			 e1.printStackTrace();
//			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
//		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getUserWishesByUserIdAndCommitte(long userId) throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try {
			UserWishDTO userWishDTO = _userWishService.getUserWishesByUserIdAndCommitte(userId);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userWishDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO managerAssignUserWish(List<UserWishDTO> list) throws ControllerException {
		ResponseDTO responseDTO = null;
		String result = "";
		try {
		UserWishDTO wishObj = _userWishService.getUserWishesByUserIdAndCommitte(list.get(0).getNominatedUser().getUserId());
		if (wishObj.getId().equals(-1L)) {
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
		responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
				result);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

}
