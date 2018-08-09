package com.sbm.shura.management.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.commonlib.dtoresponsehandler.ResponseDTO;
import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.ControllerException;
import com.sbm.shura.dto.ExperienceDTO;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.PermissionDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.management.UserManagement;
import com.sbm.shura.service.GroupService;
import com.sbm.shura.service.MenuService;
import com.sbm.shura.service.PermissionService;
import com.sbm.shura.service.UserService;

@Component
public class UserManagementImpl implements UserManagement {

	@Autowired
	private UserService userService;

	@Autowired
	private GroupService groupService;

	@Autowired
	private PermissionService permSerivce;

	@Autowired
	private MenuService menuService;

	@Override
	public ResponseDTO createUser(UserDTO user, String groupName) {
		ResponseDTO responseDTO = null;
		try {
			UserDTO userDTO = userService.add(user, groupName);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO add(GroupDTO group) throws ControllerException{
		ResponseDTO responseDTO = null;
		try {
			GroupDTO groupDTO = groupService.add(group);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					groupDTO);
		} catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getByEName(String name) throws ControllerException {

		ResponseDTO responseDTO = null;
		try {
			GroupDTO groupDTO = groupService.getByEName(name);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					groupDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getGroupList() throws ControllerException {
		ResponseDTO responseDTO = null;
		try {
			List<GroupDTO> groupDTOs = groupService.getgroupList();
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					groupDTOs);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO addMenu(MenuDTO item) throws ControllerException{
		ResponseDTO responseDTO = null;
		try {
			MenuDTO menuDTO = menuService.addMenu(item);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					menuDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getMenuList() throws ControllerException{
		
		ResponseDTO responseDTO = null;
		try {
			 List<MenuDTO> menuDTO = menuService.getMenuList();
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					menuDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO addPermission(PermissionDTO perm) throws ControllerException{
		ResponseDTO responseDTO = null;
		try {
			PermissionDTO permissionDTO = permSerivce.addPermission(perm);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					permissionDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getPermList() throws ControllerException {
		ResponseDTO responseDTO = null;
		try {
			 List<PermissionDTO> permissionDTO = permSerivce.getPermList();
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					permissionDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO getPermListByMenu(long menuId) throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try {
			List<PermissionDTO> permissionDTOs = permSerivce.getPermListByMenu(menuId);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					permissionDTOs);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO listUsers() throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try {
			List<UserDTO> userDTOs = userService.listUsers();
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTOs);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO login(String email, String password) throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try {
			UserDTO userDTO = userService.login(email, password);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO findByEmail(String email) throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try {
			UserDTO userDTO = userService.findByEmail(email);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO assignGroupToUser(String groupName, String email) throws ControllerException{
		ResponseDTO responseDTO = null;
		try {
			UserDTO userDTO = userService.assignGroupToUser(groupName, email);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

	@Override
	public ResponseDTO findById(long userId) throws ControllerException {
		
		ResponseDTO responseDTO = null;
		try {
			UserDTO userDTO = userService.findById(userId);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTO);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}
	
	@Override
	public ResponseDTO assignExperiencesToUsers(Map<String, List<ExperienceDTO>> map) throws ControllerException{
		ResponseDTO responseDTO = null;
		try {
			if(!map.isEmpty()) {
			List<UserDTO> userDTO = userService.assignExperiencesToUsers(map);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "successfully", "successfully",
					userDTO);
		}
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		return responseDTO;
	}

}
