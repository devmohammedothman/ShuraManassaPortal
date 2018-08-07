package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.NominationLogDTO;
import com.sbm.shura.dto.UserWishDTO;

public interface NominationManage {
	
	ResponseDTO addUserWish(List<UserWishDTO> list)  throws ControllerException;
	
	ResponseDTO getUserWishList()  throws ControllerException;
	
	public ResponseDTO getUserWishesByUserIdAndCommitte(long userId)  throws ControllerException;
	
	ResponseDTO managerAssignUserWish(List<UserWishDTO> list)  throws ControllerException;
	
	ResponseDTO addPOllLog(NominationLogDTO logDtoObj) throws ControllerException;
	
	ResponseDTO runPollProcess(NominationLogDTO logDtoObj) throws ControllerException;
}
