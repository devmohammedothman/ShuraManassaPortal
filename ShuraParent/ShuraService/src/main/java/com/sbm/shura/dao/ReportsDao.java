package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dto.ReportCommitteeWishesCountDTO;
import com.sbm.shura.dto.ReportUsersNotSubmitWishesDTO;
import com.sbm.shura.dto.ReportUsersWishesDTO;

public interface ReportsDao {
	
	public List<ReportUsersWishesDTO> getReportUsersWishes() throws RespositoryException;
	public  List<ReportCommitteeWishesCountDTO> getReportCommitteeWishesCount() throws RespositoryException;
	public List<ReportUsersNotSubmitWishesDTO> getReportUsersNotSubmitWishes() throws RespositoryException;
	public List<ReportUsersWishesDTO> getReportUsersWishesCommittee(long committeeId) throws RespositoryException;

}
