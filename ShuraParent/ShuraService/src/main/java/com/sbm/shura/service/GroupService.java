package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.GroupDTO;

public interface GroupService {

	GroupDTO add(GroupDTO group) throws Exception;
	
	GroupDTO getByEName(String name) throws Exception;

	List<GroupDTO> getgroupList() throws Exception;
}
