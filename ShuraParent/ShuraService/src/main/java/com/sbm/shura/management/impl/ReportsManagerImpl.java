package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.dtoresponsehandler.ResponseStatusDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.ReportCommitteeWishesCountPercDTO;
import com.sbm.shura.dto.ReportUsersNotSubmitWishesDTO;
import com.sbm.shura.dto.ReportUsersWishesDTO;
import com.sbm.shura.management.ReportsManager;
import com.sbm.shura.service.ReportsService;

@Component
public class ReportsManagerImpl implements ReportsManager{
	
	@Autowired
	private ReportsService reportsService;

	@Override
	public ResponseDTO getReportUsersWishes() throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = reportsService.getReportUsersWishes();
			ResponseStatusDTO status = new ResponseStatusDTO("Shura.business.code.1000", 
					"successfully", 
					"successfully", null);
			result =  new ResponseDTO(status, reportUsersWishesDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}

	@Override
	public ResponseDTO getReportCommitteeWishesCount() throws ControllerException {
		ResponseDTO result = null;
		try {
			ReportCommitteeWishesCountPercDTO reportDTO = reportsService.getReportCommitteeWishesCount();
			ResponseStatusDTO status = new ResponseStatusDTO("Shura.business.code.1000", 
					"successfully", 
					"successfully", null);
			result =  new ResponseDTO(status, reportDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}

	@Override
	public ResponseDTO getReportUsersNotSubmitWishes() throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersNotSubmitWishesDTO> reportUsersNotSubmitWishesDTO = reportsService.getReportUsersNotSubmitWishes();
			ResponseStatusDTO status = new ResponseStatusDTO("Shura.business.code.1000", 
					"successfully", 
					"successfully", null);
			result =  new ResponseDTO(status, reportUsersNotSubmitWishesDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}

	@Override
	public ResponseDTO getReportUsersWishesCommittee(long committeeId) throws ControllerException {
		ResponseDTO result = null;
		try {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = reportsService.getReportUsersWishesCommittee(committeeId);
			ResponseStatusDTO status = new ResponseStatusDTO("Shura.business.code.1000", 
					"successfully", 
					"successfully", null);
			result =  new ResponseDTO(status, reportUsersWishesDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}

}
