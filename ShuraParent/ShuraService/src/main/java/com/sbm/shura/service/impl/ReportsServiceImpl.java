package com.sbm.shura.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.ReportsDao;
import com.sbm.shura.dto.ReportCommitteeWishesCountDTO;
import com.sbm.shura.dto.ReportCommitteeWishesCountPercDTO;
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
	public ReportCommitteeWishesCountPercDTO getReportCommitteeWishesCount() throws BusinessException {
		ReportCommitteeWishesCountPercDTO result;
		ReportCommitteeWishesCountPercDTO reportDTO = new ReportCommitteeWishesCountPercDTO();
		try {
			List<ReportCommitteeWishesCountDTO> reportCommitteeWishesCountDTO = reportsDao.getReportCommitteeWishesCount();
			double firstWishCountTotal = 0;
			double secondWishCountTotal = 0;
			double thirdWishCountTotal = 0;
			double totalWishCountTotal = 0;
			double firstWishCountPerc = 0;
			double secondWishCountPerc = 0;
			double thirdWishCountPerc = 0;
			double totalWishCountPerc = 0;
			for(int i=0 ; i <reportCommitteeWishesCountDTO.size(); i++) {
				firstWishCountTotal  = firstWishCountTotal  + reportCommitteeWishesCountDTO.get(i).getFirstWishCount ().intValue();
				secondWishCountTotal = secondWishCountTotal + reportCommitteeWishesCountDTO.get(i).getSecondWishCount().intValue();
				thirdWishCountTotal  = thirdWishCountTotal  + reportCommitteeWishesCountDTO.get(i).getThirdWishCount ().intValue();
				totalWishCountTotal  = totalWishCountTotal  + reportCommitteeWishesCountDTO.get(i).getTotalWishCount ().intValue();
			}
			
			if(!reportCommitteeWishesCountDTO.isEmpty()) {
			firstWishCountPerc  = roundToNDigits( ( (firstWishCountTotal/totalWishCountTotal) * 100 ) , 1 );
			secondWishCountPerc = roundToNDigits( ( (secondWishCountTotal/totalWishCountTotal) * 100 ) , 1 );
			thirdWishCountPerc  = roundToNDigits( ( (thirdWishCountTotal/totalWishCountTotal) * 100 ) , 1 );
			totalWishCountPerc = firstWishCountPerc + secondWishCountPerc + thirdWishCountPerc;
			
			reportDTO.setReportCommitteeWishesCount(reportCommitteeWishesCountDTO);
			
			reportDTO.setFirstWishCountTotal(new BigDecimal(firstWishCountTotal));
			reportDTO.setSecondWishCountTotal(new BigDecimal(secondWishCountTotal));
			reportDTO.setThirdWishCountTotal(new BigDecimal(thirdWishCountTotal));
			reportDTO.setTotalWishCountTotal(new BigDecimal(totalWishCountTotal));
			
			reportDTO.setFirstWishCountPerc(firstWishCountPerc);
			reportDTO.setSecondWishCountPerc(secondWishCountPerc);
			reportDTO.setThirdWishCountPerc(thirdWishCountPerc);
			reportDTO.setTotalWishCountPerc(Math.round(totalWishCountPerc));
			}
			
			result = reportDTO;
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
	
	private double roundToNDigits(double value, int nDigits) {
 		return Math.round(value * (10 * nDigits)) / (double) (10 * nDigits);
 	}

	@Override
	public List<ReportUsersWishesDTO> getReportUsersWishesCommitteeMember(long committeeId) throws BusinessException {
		List<ReportUsersWishesDTO> result;
		try {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = reportsDao.getReportUsersWishesCommitteeMember(committeeId);
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
	public List<ReportUsersNotSubmitWishesDTO> getReportUsersCommitteeMember(long committeeId) throws BusinessException {
		List<ReportUsersNotSubmitWishesDTO> result;
		try {
			List<ReportUsersNotSubmitWishesDTO> reportUsersNotSubmitWishesDTO = reportsDao.getReportUsersCommitteeMember(committeeId);
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
	public List<ReportUsersWishesDTO> getReportUsersWishesNotTrueReport() throws BusinessException {
		List<ReportUsersWishesDTO> result;
		try {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = reportsDao.getReportUsersWishesNotTrueReport();
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
