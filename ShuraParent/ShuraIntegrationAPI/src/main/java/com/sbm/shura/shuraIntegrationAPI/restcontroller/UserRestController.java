package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.List;
import java.util.Map;

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
import com.sbm.shura.dto.ExperienceDTO;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.PermissionDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.management.UserManagement;

@RestController
//@RequestMapping("/api")
@CrossOrigin("*")
public class UserRestController {

	@Resource
	private UserManagement manage;
	
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping(value = "/api/user/register", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO register(@RequestBody Map<String, String> map) throws ControllerException{
		UserDTO dto = new UserDTO(0, map.get("email"), map.get("password"), map.get("username"));
		return manage.createUser(dto, map.get("groupName"));
	}
	
	@RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO login(@RequestBody Map<String, String> map) throws ControllerException {
		return manage.login(map.get("email"), map.get("password"));
	}
	
	@RequestMapping(value = "/api/user/getusers", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllUsers() throws ControllerException {
		return manage.listUsers();
	}
	
	@RequestMapping(value = "/api/user/assigngroup", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO assignGroupToUser(@RequestBody Map<String, String> map) throws ControllerException{
		return manage.assignGroupToUser(map.get("groupname"), map.get("email"));
	}
	
	@RequestMapping(value = "/api/user/addpermission", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addPermissio(@RequestBody PermissionDTO permDto) throws ControllerException{
		return manage.addPermission(permDto);
	}
	
	@RequestMapping(value = "/api/user/getpermissions", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllPermission() throws ControllerException{
		return manage.getPermList();
	}
	
	@RequestMapping(value = "/api/user/addmenu", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addMenu(@RequestBody MenuDTO menuDto) throws ControllerException{
		return manage.addMenu(menuDto);
	}
	
	@RequestMapping(value = "/api/user/getmenus", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllMenus() throws ControllerException {
		return manage.getMenuList();
	}
	
	@RequestMapping(value = "/api/user/addgroup", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addGroup(@RequestBody GroupDTO menuDto) throws ControllerException{
		return manage.add(menuDto);
	}
	
	@RequestMapping(value = "/api/user/getgroups", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllGroups() throws ControllerException{
		return manage.getGroupList();
	}
	
	@RequestMapping(value = "/api/user/getpermissionsbymenu/{id}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getPermissionByMenu(@PathVariable("id") long menuId) throws ControllerException{
		return manage.getPermListByMenu(menuId);
	}
	
	@RequestMapping(value = "/api/user/assignExperience", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO assignExperienceToUser(@RequestBody Map<String, List<ExperienceDTO>> map) throws ControllerException{
		return manage.assignExperiencesToUsers(map);
	}
}
