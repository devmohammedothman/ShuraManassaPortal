package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.GroupDao;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.entity.Group;
import com.sbm.shura.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl extends BasicServiceImpl<GroupDTO, Group> implements GroupService {

	@Autowired
	private GroupDao dao;

	private Group _group = new Group();

	@Override
	public GroupDTO add(GroupDTO group) throws BusinessException{
		GroupDTO result = null;
		try {
		_group = convertToEntity(_group, group);
		_group = dao.add(_group);
		result = convertToDTO(_group, group);
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
	public List<GroupDTO> getgroupList() throws BusinessException{
		List<GroupDTO> result;
		try {
		List<Group> groupListResult = dao.getgroupList();
		List<GroupDTO> groupDtoList = groupListResult.stream().map(item -> convertToDTO(item, new GroupDTO()))
				.collect(Collectors.toList());
		result = groupDtoList;
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
	public GroupDTO getByEName(String name) throws BusinessException{
		GroupDTO result;
		try {
		_group = dao.getByEName(name);
		GroupDTO groupDto = new GroupDTO();
		groupDto = convertToDTO(_group, groupDto);
		result = groupDto;
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
