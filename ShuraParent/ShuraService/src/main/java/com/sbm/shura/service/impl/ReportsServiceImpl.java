package com.sbm.shura.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.ReportsDao;
import com.sbm.shura.dto.ReportCommitteeWishesCountDTO;
import com.sbm.shura.dto.ReportUsersNotSubmitWishesDTO;
import com.sbm.shura.dto.ReportUsersWishesDTO;
import com.sbm.shura.service.ReportsService;

@Service
public class ReportsServiceImpl implements ReportsService {
	
	@Autowired
	private ReportsDao reportsDao;

	@Override
	public List<ReportUsersWishesDTO> getReportUsersWishes() throws BusinessException {
		List<ReportUsersWishesDTO> result;
		try {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = reportsDao.getReportUsersWishes();
			result = reportUsersWishesDTO;
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	public List<ReportCommitteeWishesCountDTO> getReportCommitteeWishesCount() throws BusinessException {
		List<ReportCommitteeWishesCountDTO> result;
		try {
			List<ReportCommitteeWishesCountDTO> reportCommitteeWishesCountDTO = reportsDao.getReportCommitteeWishesCount();
			result = reportCommitteeWishesCountDTO;
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	public List<ReportUsersNotSubmitWishesDTO> getReportUsersNotSubmitWishes() throws BusinessException {
		List<ReportUsersNotSubmitWishesDTO> result;
		try {
			List<ReportUsersNotSubmitWishesDTO> reportUsersNotSubmitWishesDTO = reportsDao.getReportUsersNotSubmitWishes();
			result = reportUsersNotSubmitWishesDTO;
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	public List<ReportUsersWishesDTO> getReportUsersWishesCommittee(long committeeId) throws BusinessException {
		List<ReportUsersWishesDTO> result;
		try {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = reportsDao.getReportUsersWishesCommittee(committeeId);
			result = reportUsersWishesDTO;
		} catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

}
