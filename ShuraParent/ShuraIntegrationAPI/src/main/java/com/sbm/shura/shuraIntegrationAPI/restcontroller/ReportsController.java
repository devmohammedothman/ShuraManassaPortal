package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.management.ReportsManager;

@RestController
@RequestMapping("/api/report/")
@CrossOrigin("*")
public class ReportsController {
	
	@Resource
	private ReportsManager reportsManager;
	
	@RequestMapping(value = "/reportUsersWishes", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getReportUsersWishes() throws ControllerException {
		
		return reportsManager.getReportUsersWishes();
	}
	
	@RequestMapping(value = "/reportCommitteeWishesCount", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getReportCommitteeWishesCount() throws ControllerException {
		
		return reportsManager.getReportCommitteeWishesCount();
	}
	
	@RequestMapping(value = "/reportUsersNotSubmitWishes", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getReportUsersNotSubmitWishes() throws ControllerException {
		
		return reportsManager.getReportUsersNotSubmitWishes();
	}
	
	@RequestMapping(value = "/reportUsersWishesCommittee", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getReportUsersWishesCommittee(@RequestParam("committeeId") long committeeId) throws ControllerException {
		
		return reportsManager.getReportUsersWishesCommittee(committeeId);
	}
	
}