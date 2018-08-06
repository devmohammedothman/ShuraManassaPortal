package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.PermissionDao;
import com.sbm.shura.dto.PermissionDTO;
import com.sbm.shura.entity.Permission;
import com.sbm.shura.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl extends BasicServiceImpl<PermissionDTO, Permission> implements PermissionService{
	@Autowired
	private PermissionDao permDao;
	
	private Permission _perm = new Permission();

	@Override
	public PermissionDTO addPermission(PermissionDTO perm) throws BusinessException{
		PermissionDTO result;
		try {
		_perm = convertToEntity(_perm , perm);
		_perm = permDao.add(_perm);
		result = convertToDTO(_perm,perm);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	public List<PermissionDTO> getPermList() throws BusinessException{
		List<PermissionDTO> result;
		try {
		List<Permission> permListResult =  permDao.getPermList();
		List<PermissionDTO> permDtoList =  permListResult.stream().
				map(item -> convertToDTO(item, new PermissionDTO())).collect(Collectors.toList());
		result = permDtoList;
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	public List<PermissionDTO> getPermListByMenu(long menuId) throws BusinessException{
		List<PermissionDTO> result;
		try {
		List<Permission> permListResult =  permDao.getPermListByMenu(menuId);
		List<PermissionDTO> permDtoList =  permListResult.stream().
				map(item -> convertToDTO(item, new PermissionDTO())).collect(Collectors.toList());
		result = permDtoList;
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}
}
