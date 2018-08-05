package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.ResponseDTO;
import com.sbm.shura.management.CommitteeManager;

@RestController
@RequestMapping("/api/comm/")
@CrossOrigin("*")
public class CommitteeController {
	
	@Resource
	private CommitteeManager commManager;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping(value = "/getcommlist", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllCommittees()
	{
		return commManager.getCommitteeList();
	}
	
	@RequestMapping (value = "/addcomm", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addCommittee(@RequestBody CommitteeDTO commDtoObj) throws Exception
	{
		return commManager.addCommittee(commDtoObj);
	}
	
}
