package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.dao.GroupDao;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.entity.Group;
import com.sbm.shura.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl extends BasicServiceImpl<GroupDTO, Group> implements GroupService {

	@Autowired
	private GroupDao dao;

	private Group _group = new Group();

	@Override
	public GroupDTO add(GroupDTO group) throws Exception {
		_group = convertToEntity(_group, group);
		_group = dao.add(_group);
		return convertToDTO(_group, group);
	}

	@Override
	public List<GroupDTO> getgroupList() throws Exception {
		List<Group> groupListResult = dao.getgroupList();
		List<GroupDTO> groupDtoList = groupListResult.stream().map(item -> convertToDTO(item, new GroupDTO()))
				.collect(Collectors.toList());
		return groupDtoList;
	}

	@Override
	public GroupDTO getByEName(String name) throws Exception {
		_group = dao.getByEName(name);
		GroupDTO groupDto = new GroupDTO();
		groupDto = convertToDTO(_group, groupDto);
		return groupDto;
	}

}
