package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.NominationLogDTO;
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
	
}