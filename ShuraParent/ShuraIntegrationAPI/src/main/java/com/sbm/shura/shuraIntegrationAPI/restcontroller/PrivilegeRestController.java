package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.dto.BaseDTO;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.PermissionDTO;
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
	
	@RequestMapping(value = "/perm/addpermission", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addPermissio(@RequestBody PermissionDTO permDto) throws Exception{
		return dtoProvider.addObj(service.addPermission(permDto));
	}
	
	@RequestMapping(value = "/perm/getpermissions", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<PermissionDTO>> getAllPermission() throws Exception {
		return dtoProvider.getObjList((List) service.getPermList());
	}
	
	@RequestMapping(value = "/perm/addmenu", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addMenu(@RequestBody MenuDTO menuDto) throws Exception{
		return dtoProvider.addObj(menuService.addMenu(menuDto));
	}
	
	@RequestMapping(value = "/perm/getmenus", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<MenuDTO>> getAllMenus() throws Exception {
		return dtoProvider.getObjList((List) menuService.getMenuList());
	}
	
	@RequestMapping(value = "/perm/addgroup", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addGroup(@RequestBody GroupDTO menuDto) throws Exception{
		return dtoProvider.addObj(groupService.add(menuDto));
	}
	
	@RequestMapping(value = "/perm/getgroups", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<GroupDTO>> getAllGroups() throws Exception {
		return dtoProvider.getObjList((List) groupService.getgroupList());
	}
	
	@RequestMapping(value = "/perm/getpermissionsbymenu/{id}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<PermissionDTO>> getPermissionByMenu(@PathVariable("id") long menuId) throws Exception {
		return dtoProvider.getObjList((List) service.getPermListByMenu(menuId));
	}
	
}
