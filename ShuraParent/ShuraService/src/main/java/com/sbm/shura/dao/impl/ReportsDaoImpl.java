package com.sbm.shura.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.ReportsDao;
import com.sbm.shura.dto.ReportCommitteeWishesCountDTO;
import com.sbm.shura.dto.ReportUsersNotSubmitWishesDTO;
import com.sbm.shura.dto.ReportUsersWishesDTO;

@Repository
public class ReportsDaoImpl implements  ReportsDao {
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportUsersWishesDTO> getReportUsersWishes() throws RespositoryException {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = new ArrayList<ReportUsersWishesDTO>();
			try {
				String sql = "SELECT DISTINCT u.USERNAME, (SELECT c.NAME_EN FROM COMMITTEE c join COMMITTEEMEMBER cm on cm.COMMITTEEID = c.ID WHERE u.ID = cm.MEMBERID), " +
						"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 1 and u.ID = uw.NOMINATEDUSERID), " + 
						"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 2 and u.ID = uw.NOMINATEDUSERID), " + 
						"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 3 and u.ID = uw.NOMINATEDUSERID) FROM SHURA.\"USER\" u " + 
						"join USERWISH uwish on u.ID = uwish.NOMINATEDUSERID";
				Query query = entityManager.createNativeQuery(sql);
		    	List<Object[]> details = query.getResultList();
		    	System.out.println("IN DAO: " + details.size());
		    	for (Object[] a : details) {
		    		ReportUsersWishesDTO uW = new ReportUsersWishesDTO();
		    		uW.setUserName((String)a[0]);
		    		uW.setCurrentCommittee((String)a[1]);
		    		uW.setFirstWish((String)a[2]);
		    		uW.setSecondWish((String)a[3]);
		    		uW.setThirdWish((String)a[4]);
		    		reportUsersWishesDTO.add(uW);
		    	}
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
			   }
			return reportUsersWishesDTO;
		}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportCommitteeWishesCountDTO> getReportCommitteeWishesCount() throws RespositoryException {
		List<ReportCommitteeWishesCountDTO> reportCommitteeWishesCountDTO = new ArrayList<ReportCommitteeWishesCountDTO>();
		try {
			String sql = "select DISTINCT c.NAME_EN , (SELECT COUNT(uuw.COMMITTEEID) FROM USERWISH uuw WHERE uuw.COMMITTEEID = c.ID and uuw.WISHORDER = 1), " + 
					"(SELECT COUNT(uuw.COMMITTEEID) FROM USERWISH uuw WHERE uuw.COMMITTEEID = c.ID and uuw.WISHORDER = 2), " + 
					"(SELECT COUNT(uuw.COMMITTEEID) FROM USERWISH uuw WHERE uuw.COMMITTEEID = c.ID and uuw.WISHORDER = 3), " + 
					"(SELECT COUNT(uuw.COMMITTEEID) FROM USERWISH uuw WHERE uuw.COMMITTEEID = c.ID) from COMMITTEE c " + 
					"join " + 
					"USERWISH uw on c.ID = uw.COMMITTEEID";
			Query query = entityManager.createNativeQuery(sql);
	    	List<Object[]> details = query.getResultList();
	    	System.out.println("IN DAO: " + details.size());
	    	for (Object[] a : details) {
	    		ReportCommitteeWishesCountDTO rC = new ReportCommitteeWishesCountDTO();
	    		rC.setCommitteeName((String)a[0]);
	    		rC.setFirstWishCount((BigDecimal)a[1]);
	    		rC.setSecondWishCount((BigDecimal)a[2]);
	    		rC.setThirdWishCount((BigDecimal)a[3]);
	    		rC.setTotalWishCount((BigDecimal)a[4]);
	    		reportCommitteeWishesCountDTO.add(rC);
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return reportCommitteeWishesCountDTO;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportUsersNotSubmitWishesDTO> getReportUsersNotSubmitWishes() throws RespositoryException {
		List<ReportUsersNotSubmitWishesDTO> reportUsersNotSubmitWishesDTO = new ArrayList<ReportUsersNotSubmitWishesDTO>();
		try {
			String sql = "select DISTINCT  u.USERNAME, (SELECT c.NAME_AR FROM COMMITTEE c join COMMITTEEMEMBER cm on cm.COMMITTEEID = c.ID WHERE u.ID = cm.MEMBERID) As CurrentCommittee from SHURA.\"USER\" u FULL OUTER join USERWISH uw on u.ID = uw.NOMINATEDUSERID where uw.NOMINATEDUSERID is null";
			Query query = entityManager.createNativeQuery(sql);
	    	List<Object[]> details = query.getResultList();
	    	System.out.println("IN DAO: " + details.size());
	    	for (Object[] a : details) {
	    		ReportUsersNotSubmitWishesDTO uN = new ReportUsersNotSubmitWishesDTO();
	    		uN.setUserName((String)a[0]);
	    		uN.setCurrentCommittee((String)a[1]);
	    		reportUsersNotSubmitWishesDTO.add(uN);
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return reportUsersNotSubmitWishesDTO;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportUsersWishesDTO> getReportUsersWishesCommittee(long committeeId) throws RespositoryException {
		List<ReportUsersWishesDTO> reportUsersWishesDTO = new ArrayList<ReportUsersWishesDTO>();
		try {
			String sql = "SELECT DISTINCT u.USERNAME, (SELECT c.NAME_EN FROM COMMITTEE c join COMMITTEEMEMBER cm on cm.COMMITTEEID = c.ID WHERE u.ID = cm.MEMBERID), " +
					"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 1 and u.ID = uw.NOMINATEDUSERID), " + 
					"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 2 and u.ID = uw.NOMINATEDUSERID), " + 
					"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 3 and u.ID = uw.NOMINATEDUSERID) FROM SHURA.\"USER\" u " + 
					"join USERWISH uwish on u.ID = uwish.NOMINATEDUSERID  WHERE uwish.COMMITTEEID = ?";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1,committeeId);
	    	List<Object[]> details = query.getResultList();
	    	System.out.println("IN DAO: " + details.size());
	    	for (Object[] a : details) {
	    		ReportUsersWishesDTO uW = new ReportUsersWishesDTO();
	    		uW.setUserName((String)a[0]);
	    		uW.setCurrentCommittee((String)a[1]);
	    		uW.setFirstWish((String)a[2]);
	    		uW.setSecondWish((String)a[3]);
	    		uW.setThirdWish((String)a[4]);
	    		reportUsersWishesDTO.add(uW);
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return reportUsersWishesDTO;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportUsersWishesDTO> getReportUsersWishesCommitteeMember(long committeeId) throws RespositoryException {
		List<ReportUsersWishesDTO> reportUsersWishesDTO = new ArrayList<ReportUsersWishesDTO>();
		try {
			String sql = "SELECT DISTINCT u.USERNAME, (SELECT c.NAME_EN FROM COMMITTEE c join COMMITTEEMEMBER cm on cm.COMMITTEEID = c.ID WHERE u.ID = cm.MEMBERID), " +
					"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 1 and u.ID = uw.NOMINATEDUSERID), " + 
					"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 2 and u.ID = uw.NOMINATEDUSERID), " + 
					"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 3 and u.ID = uw.NOMINATEDUSERID) FROM SHURA.\"USER\" u " + 
					"join COMMITTEEMEMBER cm on cm.MEMBERID = u.ID WHERE cm.COMMITTEEID = ?";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1,committeeId);
	    	List<Object[]> details = query.getResultList();
	    	System.out.println("IN DAO: " + details.size());
	    	for (Object[] a : details) {
	    		ReportUsersWishesDTO uW = new ReportUsersWishesDTO();
	    		uW.setUserName((String)a[0]);
	    		uW.setCurrentCommittee((String)a[1]);
	    		uW.setFirstWish((String)a[2]);
	    		uW.setSecondWish((String)a[3]);
	    		uW.setThirdWish((String)a[4]);
	    		reportUsersWishesDTO.add(uW);
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return reportUsersWishesDTO;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportUsersNotSubmitWishesDTO> getReportUsersCommitteeMember(long committeeId) throws RespositoryException {
		List<ReportUsersNotSubmitWishesDTO> reportUsersNotSubmitWishesDTO = new ArrayList<ReportUsersNotSubmitWishesDTO>();
		try {
			String sql = "select DISTINCT  u.USERNAME, (SELECT c.NAME_AR FROM COMMITTEE c join COMMITTEEMEMBER cm on cm.COMMITTEEID = c.ID WHERE u.ID = cm.MEMBERID) As CurrentCommittee from SHURA.\"USER\" u join COMMITTEEMEMBER cm on cm.MEMBERID = u.ID WHERE cm.COMMITTEEID = ?";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1,committeeId);
	    	List<Object[]> details = query.getResultList();
	    	System.out.println("IN DAO: " + details.size());
	    	for (Object[] a : details) {
	    		ReportUsersNotSubmitWishesDTO uN = new ReportUsersNotSubmitWishesDTO();
	    		uN.setUserName((String)a[0]);
	    		uN.setCurrentCommittee((String)a[1]);
	    		reportUsersNotSubmitWishesDTO.add(uN);
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return reportUsersNotSubmitWishesDTO;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ReportUsersWishesDTO> getReportUsersWishesNotTrueReport() throws RespositoryException {
			List<ReportUsersWishesDTO> reportUsersWishesDTO = new ArrayList<ReportUsersWishesDTO>();
			try {
				String sql = "SELECT DISTINCT u.USERNAME, (SELECT c.NAME_EN FROM COMMITTEE c join COMMITTEEMEMBER cm on cm.COMMITTEEID = c.ID WHERE u.ID = cm.MEMBERID), " +
						"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 1 and u.ID = uw.NOMINATEDUSERID), " + 
						"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 2 and u.ID = uw.NOMINATEDUSERID), " + 
						"(SELECT c.NAME_EN FROM COMMITTEE c join USERWISH uw on uw.COMMITTEEID = c.ID WHERE uw.WISHORDER = 3 and u.ID = uw.NOMINATEDUSERID) FROM SHURA.\"USER\" u " + 
						"join COMMITTEEMEMBER cm on u.ID = cm.MEMBERID " + 
						"join  USERWISH uwish1 on cm.MEMBERID = uwish1.NOMINATEDUSERID " + 
						"join  USERWISH uwish2 on cm.MEMBERID = uwish2.NOMINATEDUSERID " + 
						"join  USERWISH uwish3 on cm.MEMBERID = uwish3.NOMINATEDUSERID " + 
						"WHERE (uwish1.WISHORDER = 1 and uwish1.COMMITTEEID != cm.COMMITTEEID) AND (uwish2.WISHORDER = 2 and uwish2.COMMITTEEID != cm.COMMITTEEID) AND " + 
						"(uwish3.WISHORDER = 3 AND uwish3.COMMITTEEID != cm.COMMITTEEID)";
				Query query = entityManager.createNativeQuery(sql);
		    	List<Object[]> details = query.getResultList();
		    	System.out.println("IN DAO: " + details.size());
		    	for (Object[] a : details) {
		    		ReportUsersWishesDTO uW = new ReportUsersWishesDTO();
		    		uW.setUserName((String)a[0]);
		    		uW.setCurrentCommittee((String)a[1]);
		    		uW.setFirstWish((String)a[2]);
		    		uW.setSecondWish((String)a[3]);
		    		uW.setThirdWish((String)a[4]);
		    		reportUsersWishesDTO.add(uW);
		    	}
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
			   }
			return reportUsersWishesDTO;
		}
}
