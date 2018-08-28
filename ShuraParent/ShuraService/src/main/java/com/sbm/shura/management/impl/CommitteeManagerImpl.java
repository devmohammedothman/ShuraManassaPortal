package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.CommitteeMemberDTO;
import com.sbm.shura.management.CommitteeManager;
import com.sbm.shura.service.CommitteeMemberService;
import com.sbm.shura.service.CommitteeService;

@Component
public class CommitteeManagerImpl implements CommitteeManager {
	
	@Autowired
	private CommitteeService commService; 
	@Autowired
	private CommitteeMemberService commMemService; 

	@Override
	public ResponseDTO addCommittee(CommitteeDTO obj) throws ControllerException  {
		ResponseDTO responseDTO = null;
		try {
			CommitteeDTO committeeDTO = commService.addCommittee(obj);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "Commitee has been added successfully", "Commitee has been added successfully",
					committeeDTO);
		} catch(BusinessException e) {
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
	public ResponseDTO getCommitteeList() throws ControllerException  {
		ResponseDTO responseDTO = null;
		try {
			List<CommitteeDTO> committeeDTOs = commService.getCommitteeList();
			 responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitees has been retrieved successfully", "Commitees has been retrieved successfully",
						committeeDTOs);
		} catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
//			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getCommitteeById(int id) throws ControllerException  {
		ResponseDTO responseDTO = null;
		try {
			CommitteeDTO committeeDTO = commService.getCommitteeById(id);
			 responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitee has been retrieved successfully", "Commitee has been retrieved successfully",
						committeeDTO);
		} catch(BusinessException e) {
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
	public ResponseDTO updateCommittee(CommitteeDTO obj) throws ControllerException  {
		ResponseDTO responseDTO = null;
		try {
			CommitteeDTO committeeDTO = commService.updateCommittee(obj);
			responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitee has been retrieved successfully", "Commitee has been retrieved successfully",
					committeeDTO);
		} catch(BusinessException e) {
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
	public ResponseDTO deleteCommittee(int id) throws ControllerException  {
		ResponseDTO responseDTO = null;
		try {
			commService.deleteCommittee(id);
			responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitee has been deleted successfully", "Commitee has been deleted successfully",
					null);
		} catch(BusinessException e) {
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
