package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.GroupDTO;

public interface GroupService {

	GroupDTO add(GroupDTO group)  throws BusinessException;
	
	GroupDTO getByEName(String name)  throws BusinessException;

	List<GroupDTO> getgroupList()  throws BusinessException;
}
