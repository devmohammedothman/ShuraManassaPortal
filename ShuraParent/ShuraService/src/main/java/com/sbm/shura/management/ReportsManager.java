package com.sbm.shura.management;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;

public interface ReportsManager {
	
	public ResponseDTO getReportUsersWishes() throws ControllerException;
	public ResponseDTO getReportCommitteeWishesCount() throws ControllerException;
	public ResponseDTO getReportUsersNotSubmitWishes() throws ControllerException;
	public ResponseDTO getReportUsersWishesCommittee(long committeeId) throws ControllerException;
	
	public void exportReportUsersWishes() throws ControllerException;
	public void exportReportCommitteeWishesCount() throws ControllerException;
	public void exportReportUsersNotSubmitWishes() throws ControllerException;
	public void exportReportUsersWishesCommittee(long committeeId) throws ControllerException;
	public void exportReportUsersWishesCommitteeMember(long committeeId) throws ControllerException;
	public void exportReportUsersCommitteeMember(long committeeId) throws ControllerException;
	public void exportReportUsersWishesNotTrueReport() throws ControllerException;
	public void exportReportUsersAddedNote() throws ControllerException;

}
