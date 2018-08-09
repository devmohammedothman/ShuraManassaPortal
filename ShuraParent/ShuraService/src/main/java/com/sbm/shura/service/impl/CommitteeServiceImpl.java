package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
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
	public CommitteeDTO addCommittee(CommitteeDTO obj) throws BusinessException {
		CommitteeDTO committeeDTO = null;
		try {
		_committee  = new Committee();
		_committee = convertToEntity(_committee, obj);
		if(!_committee.getCommitteeExperiences().isEmpty()){
			for(int i=0 ; i < _committee.getCommitteeExperiences().size(); i++)
			_committee.getCommitteeExperiences().get(i).setCommittee(_committee);
		}
		_committee =  committeeDao.addCommittee(_committee);
		committeeDTO = convertToDTO(_committee, obj);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return committeeDTO;
	}

	@Override
	@Transactional
	public List<CommitteeDTO> getCommitteeList() throws BusinessException{
		List<CommitteeDTO> commDtoList;
		try{
		List<Committee> commList = committeeDao.listCommitees();
		commDtoList = commList.stream().map
				(item -> convertToDTO(item, new CommitteeDTO())).collect(Collectors.toList());
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return commDtoList;
	}

	@Override
	@Transactional
	public CommitteeDTO getCommitteeById(int id) throws BusinessException {
		CommitteeDTO committeeDTO = null;
		try {
		_committee  = new Committee();
		_committee = committeeDao.findById(id);
		CommitteeDTO commDtoObj = new CommitteeDTO();
		committeeDTO = convertToDTO(_committee, commDtoObj);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return committeeDTO;
	}

	@Override
	@Transactional
	public CommitteeDTO updateCommittee(CommitteeDTO obj) throws BusinessException{
		CommitteeDTO committeeDTO;
		try {
		_committee = convertToEntity(_committee, obj);
		_committee = committeeDao.findById(obj.getId());
		_committee =  committeeDao.update(_committee);
		committeeDTO = convertToDTO(_committee, obj);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return committeeDTO;
		
	}

	@Override
	@Transactional
	public void deleteCommittee(int id) throws BusinessException{
		try {
		 committeeDao.delete(id);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
	}

	@Override
	@Transactional
	public CommitteeDTO findById(long committeeId) throws BusinessException{
		CommitteeDTO committeeDTO = null;
		try {
		_committee = committeeDao.findById(committeeId);
		CommitteeDTO result = new CommitteeDTO();
		committeeDTO = convertToDTO(_committee, result);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return committeeDTO;
	}

}
