package com.sbm.shura.management;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;

public interface ReportsManager {
	
	public ResponseDTO getReportUsersWishes() throws ControllerException;
	public ResponseDTO getReportCommitteeWishesCount() throws ControllerException;
	public ResponseDTO getReportUsersNotSubmitWishes() throws ControllerException;
	public ResponseDTO getReportUsersWishesCommittee(long committeeId) throws ControllerException;

}
