package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.CommitteeMemberDTO;
import com.sbm.shura.dto.NominationLogDTO;
import com.sbm.shura.dto.PollProcessResultDto;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;

@RestController
@RequestMapping("/api/nomination/")
@CrossOrigin("*")
public class NominationRestController {

	@Resource
	private NominationManage manage;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	
	@RequestMapping (value = "addwish", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addUserWish(@RequestBody List<UserWishDTO> list) throws ControllerException
	{
		return manage.addUserWish(list);
	}
	
	
	@RequestMapping (value = "managerassignwish", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO managerAssignWish(@RequestBody List<UserWishDTO> list) throws ControllerException
	{
			return manage.managerAssignUserWish(list);
	}
	
	@RequestMapping (value = "runpollprocess", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO runPollProcess(@RequestBody NominationLogDTO logDto) throws ControllerException
	{
			return manage.runPollProcess(logDto);
	}
	
	@RequestMapping (value = "confirmpollprocess", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO confirmPollProcess(@RequestBody PollProcessResultDto pollDTO) throws ControllerException
	{
			return manage.confirmPollResult(pollDTO, pollDTO.isApproved());
	}
	
	@RequestMapping (value = "getcommitteemembers/{commId}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getCommitteeAssignedMembers(@PathVariable("commId") long commId) throws ControllerException
	{
			return manage.getCommitteeAssignedMembers(commId);
	}
	
	@RequestMapping (value = "getallcommitteemembers", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllCommitteeCurrentMember() throws ControllerException
	{
			return manage.getAllCommitteeCurrentMember();
	}
	
	@RequestMapping (value = "updatememberassignedcommittee", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updateMemberAssignedCommittee(@RequestBody CommitteeMemberDTO commMemberDto) throws ControllerException
	{
		return manage.updateMemberAssignedCommittee(commMemberDto);
	}
	
}