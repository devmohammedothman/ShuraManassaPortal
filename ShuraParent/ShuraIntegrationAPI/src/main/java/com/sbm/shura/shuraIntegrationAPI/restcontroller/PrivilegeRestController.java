package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.service.GroupService;
import com.sbm.shura.service.MenuService;
import com.sbm.shura.service.PermissionService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PrivilegeRestController {

	@Resource
	private PermissionService service;
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private GroupService groupService;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	
	
}
