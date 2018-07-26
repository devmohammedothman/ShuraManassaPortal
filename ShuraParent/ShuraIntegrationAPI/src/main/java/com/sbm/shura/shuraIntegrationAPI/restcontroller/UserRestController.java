package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.List;
import java.util.Map;

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
	public ResponseEntity<BaseDTO> register(@RequestBody Map<String, String> map){
		UserDTO dto = new UserDTO(0, map.get("email"), map.get("password"), map.get("username"));
		return dtoProvider.addObj(manage.createUser(dto, map.get("groupName")));
	}
	
	@RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BaseDTO> login(@RequestBody Map<String, String> map) {
		return dtoProvider.getObj((UserDTO) manage.login(map.get("email"), map.get("password")));
	}
	
	@RequestMapping(value = "/api/user/getusers", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return dtoProvider.getObjList((List) manage.listUsers());
	}
	
	@RequestMapping(value = "/api/user/assigngroup", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BaseDTO> assignGroupToUser(@RequestBody Map<String, String> map) throws Exception {
		return dtoProvider.getObj((UserDTO) manage.assignGroupToUser(map.get("groupname"), map.get("email")));
	}
	
	@RequestMapping(value = "/api/user/addpermission", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addPermissio(@RequestBody PermissionDTO permDto) throws Exception{
		return dtoProvider.addObj(manage.addPermission(permDto));
	}
	
	@RequestMapping(value = "/api/user/getpermissions", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<PermissionDTO>> getAllPermission() throws Exception {
		return dtoProvider.getObjList((List) manage.getPermList());
	}
	
	@RequestMapping(value = "/api/user/addmenu", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addMenu(@RequestBody MenuDTO menuDto) throws Exception{
		return dtoProvider.addObj(manage.addMenu(menuDto));
	}
	
	@RequestMapping(value = "/api/user/getmenus", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<MenuDTO>> getAllMenus() throws Exception {
		return dtoProvider.getObjList((List) manage.getMenuList());
	}
	
	@RequestMapping(value = "/api/user/addgroup", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addGroup(@RequestBody GroupDTO menuDto) throws Exception{
		return dtoProvider.addObj(manage.add(menuDto));
	}
	
	@RequestMapping(value = "/api/user/getgroups", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<GroupDTO>> getAllGroups() throws Exception {
		return dtoProvider.getObjList((List) manage.getGroupList());
	}
	
	@RequestMapping(value = "/api/user/getpermissionsbymenu/{id}", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<PermissionDTO>> getPermissionByMenu(@PathVariable("id") long menuId) throws Exception {
		return dtoProvider.getObjList((List) manage.getPermListByMenu(menuId));
	}
}
