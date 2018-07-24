package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.dto.BaseDTO;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.management.CommitteeManager;

@RestController
@RequestMapping("/secure/api/comm/")
@CrossOrigin("*")
public class CommitteeController {
	
	@Resource
	private CommitteeManager commManager;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping(value = "/getcommlist", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<CommitteeDTO>> getAllCommittees()
	{
		return dtoProvider.getObjList((List)commManager.getCommitteeList());
	}
	
	@RequestMapping (value = "/addcomm", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addCommittee(@RequestBody CommitteeDTO commDtoObj) throws Exception
	{
		return dtoProvider.addObj(commManager.addCommittee(commDtoObj));
	}
	

}
