package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.management.INominationManage;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NominationRestController {

	@Resource
	private INominationManage manage;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	
}
