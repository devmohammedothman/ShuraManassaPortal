package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public PermissionDTO addPermission(PermissionDTO perm) throws Exception {
		_perm = convertToEntity(_perm , perm);
		_perm = permDao.add(_perm);
		return convertToDTO(_perm,perm);
	}

	@Override
	public List<PermissionDTO> getPermList() throws Exception {
		List<Permission> permListResult =  permDao.getPermList();
		List<PermissionDTO> permDtoList =  permListResult.stream().
				map(item -> convertToDTO(item, new PermissionDTO())).collect(Collectors.toList());
		return permDtoList;
	}
}
