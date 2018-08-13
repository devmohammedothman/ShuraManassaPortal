package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.ReportCommitteeWishesCountDTO;
import com.sbm.shura.dto.ReportUsersNotSubmitWishesDTO;
import com.sbm.shura.dto.ReportUsersWishesDTO;

public interface ReportsService {

	public List<ReportUsersWishesDTO> getReportUsersWishes()  throws BusinessException;
	public  List<ReportCommitteeWishesCountDTO> getReportCommitteeWishesCount() throws BusinessException;
	public List<ReportUsersNotSubmitWishesDTO> getReportUsersNotSubmitWishes() throws BusinessException;
	public List<ReportUsersWishesDTO> getReportUsersWishesCommittee(long committeeId) throws BusinessException;
}
