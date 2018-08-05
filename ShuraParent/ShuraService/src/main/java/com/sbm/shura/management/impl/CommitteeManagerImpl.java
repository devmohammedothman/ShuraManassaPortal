package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.ResponseDTO;
import com.sbm.shura.management.CommitteeManager;
import com.sbm.shura.service.CommitteeService;

@Component
public class CommitteeManagerImpl implements CommitteeManager {
	
	@Autowired
	private CommitteeService commService; 

	@Override
	public ResponseDTO addCommittee(CommitteeDTO obj)  {
		ResponseDTO responseDTO = null;
		try {
			CommitteeDTO committeeDTO = commService.addCommittee(obj);
			responseDTO =  new ResponseDTO("Shura.business.code.1000", "Commitee has been added successfully", "Commitee has been added successfully",
					committeeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO getCommitteeList()  {
		ResponseDTO responseDTO = null;
		try {
			List<CommitteeDTO> committeeDTOs = commService.getCommitteeList();
			 responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitees has been retrieved successfully", "Commitees has been retrieved successfully",
						committeeDTOs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO getCommitteeById(int id)  {
		ResponseDTO responseDTO = null;
		try {
			CommitteeDTO committeeDTO = commService.getCommitteeById(id);
			 responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitee has been retrieved successfully", "Commitee has been retrieved successfully",
						committeeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO updateCommittee(CommitteeDTO obj)  {
		ResponseDTO responseDTO = null;
		try {
			CommitteeDTO committeeDTO = commService.updateCommittee(obj);
			responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitee has been retrieved successfully", "Commitee has been retrieved successfully",
					committeeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO deleteCommittee(int id)  {
		ResponseDTO responseDTO = null;
		try {
			commService.deleteCommittee(id);
			responseDTO = new ResponseDTO("Shura.business.code.1000", "Commitee has been deleted successfully", "Commitee has been deleted successfully",
					null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseDTO;
	}

}
