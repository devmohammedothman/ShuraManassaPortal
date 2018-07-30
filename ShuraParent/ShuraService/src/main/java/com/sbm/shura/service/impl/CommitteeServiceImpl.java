package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.dao.CommitteeDao;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.entity.Committee;
import com.sbm.shura.service.CommitteeService;

@Service
public class CommitteeServiceImpl extends BasicServiceImpl<CommitteeDTO, Committee> implements CommitteeService{

	@Autowired
	private CommitteeDao committeeDao;
	
	private Committee _committee;
	
//	@Override
//	protected void configureMapperLocally() {
//		modelMapper.addMappings(new PropertyMap<Committee, CommitteeDTO>() {
//			protected void configure() {
//				map().setCommManager(null);
//				//map().setNameAr(source.getNameAr());
//			}
//		});
//	}
	
	
	@Override
	@Transactional
	public CommitteeDTO addCommittee(CommitteeDTO obj) throws Exception {
		// TODO Auto-generated method stub
		_committee  = new Committee();
		_committee = convertToEntity(_committee, obj);
		_committee =  committeeDao.addCommittee(_committee);
		return convertToDTO(_committee, obj);
	}

	@Override
	@Transactional
	public List<CommitteeDTO> getCommitteeList() throws Exception {
		// TODO Auto-generated method stub
		
		List<Committee> commList = committeeDao.listCommitees();
		List<CommitteeDTO> commDtoList = commList.stream().map
				(item -> convertToDTO(item, new CommitteeDTO())).collect(Collectors.toList());
		return commDtoList;
	}

	@Override
	@Transactional
	public CommitteeDTO getCommitteeById(int id) throws Exception {
		// TODO Auto-generated method stub
		_committee  = new Committee();
		_committee = committeeDao.findById(id);
		CommitteeDTO commDtoObj = new CommitteeDTO();
		commDtoObj = convertToDTO(_committee, commDtoObj);
		return commDtoObj;
	}

	@Override
	@Transactional
	public CommitteeDTO updateCommittee(CommitteeDTO obj) throws Exception {
		// TODO Auto-generated method stub
		_committee = convertToEntity(_committee, obj);
		_committee = committeeDao.findById(obj.getId());
		_committee =  committeeDao.update(_committee);
		
		return convertToDTO(_committee, obj);
	}

	@Override
	@Transactional
	public void deleteCommittee(int id)  throws Exception {
		// TODO Auto-generated method stub
		 committeeDao.delete(id);
		
	}

	@Override
	@Transactional
	public CommitteeDTO findById(long committeeId) {
		// TODO Auto-generated method stub
		_committee = committeeDao.findById(committeeId);
		
		CommitteeDTO result = new CommitteeDTO();
	
		return convertToDTO(_committee, result);
	}

}
