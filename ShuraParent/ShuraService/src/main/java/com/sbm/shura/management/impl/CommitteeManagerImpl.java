package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.management.CommitteeManager;
import com.sbm.shura.service.CommitteeService;

@Component
public class CommitteeManagerImpl implements CommitteeManager {
	
	@Autowired
	private CommitteeService commService; 

	@Override
	public CommitteeDTO addCommittee(CommitteeDTO obj)  {
		// TODO Auto-generated method stub
		try {
			return commService.addCommittee(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CommitteeDTO> getCommitteeList()  {
		// TODO Auto-generated method stub
		try {
			return commService.getCommitteeList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CommitteeDTO getCommitteeById(int id)  {
		// TODO Auto-generated method stub
		try {
			return commService.getCommitteeById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CommitteeDTO updateCommittee(CommitteeDTO obj)  {
		// TODO Auto-generated method stub
		try {
			return commService.updateCommittee(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteCommittee(int id)  {
		// TODO Auto-generated method stub
		try {
			commService.deleteCommittee(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
