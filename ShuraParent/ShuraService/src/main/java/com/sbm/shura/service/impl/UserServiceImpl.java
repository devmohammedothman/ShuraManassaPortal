package com.sbm.shura.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.ExperienceDao;
import com.sbm.shura.dao.GroupDao;
import com.sbm.shura.dao.UserDao;
import com.sbm.shura.dto.ExperienceDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.entity.Experience;
import com.sbm.shura.entity.Group;
import com.sbm.shura.entity.MemberExperience;
import com.sbm.shura.entity.User;
import com.sbm.shura.service.UserService;

@Service
public class UserServiceImpl extends BasicServiceImpl<UserDTO, User> implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private ExperienceDao experienceDao;

	private User _user = new User();

	public UserServiceImpl() {
	}

	@Override
	@Transactional
	public UserDTO add(UserDTO userDto, String groupName) throws BusinessException {
		UserDTO result = null;
		try {
		_user = new User();
		_user = convertToEntity(_user, userDto);
		_user = userDao.add(_user);
		if (!stringIsBlank(groupName)) {
				assignGroupToUser(groupName, _user.getEmail());
		}
		result = convertToDTO(_user, userDto);
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
	@Transactional(readOnly = true)
	public List<UserDTO> listUsers() throws BusinessException {
		List<UserDTO> result;
		try {
		List<User> userListResult = userDao.listUsers();
		List<UserDTO> userDtoList = userListResult.stream().map(item -> convertToDTO(item, new UserDTO()))
				.collect(Collectors.toList());
		result = userDtoList;
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
	@Transactional(readOnly = true)
	public UserDTO login(String email, String password) throws BusinessException {
		UserDTO result = null;
		try {
		_user = userDao.login(email, password);
		if (_user == null) {
			return new UserDTO(-1L);
		}
		UserDTO userDto = new UserDTO();
		userDto = convertToDTO(_user, userDto);
		result = userDto;
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
	protected void configureMapperLocally() {
		modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
			protected void configure() {
				map().setUsername(source.getUsername());
			}
		});
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findByEmail(String email) throws BusinessException {
		UserDTO result = null;
		try {
		_user = userDao.findByEmail(email);
		if (_user == null) {
			return new UserDTO(-1L);
		}
		UserDTO userDto = new UserDTO();
		userDto = convertToDTO(_user, userDto);
		result = userDto;
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
	@Transactional
	public UserDTO assignGroupToUser(String groupName, String email) throws BusinessException {
		UserDTO result = null;
		try {
		UserDTO userDto = findByEmail(email);

		// GroupDTO groupDto = groupService.getByEName(groupName);

		Group group = groupDao.getByEName(groupName);

		// groupDto.getUsers().add(userDto);

		_user = userDao.findById(userDto.getUserId());
		group = groupDao.findById(group.getId());
		if (_user.getGroups() == null) {
			_user.setGroups(new ArrayList<Group>());
			_user.getGroups().add(group);
		} else {
		    _user.getGroups().add(group);
		}
		group.getUsers().add(_user);

		// _user = userDao.update(_user);

		result = convertToDTO(_user, userDto);
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
	@Transactional
	public UserDTO findById(long userId) throws BusinessException {
		UserDTO result = null;
		try {
		_user = userDao.findById(userId);
		
		UserDTO userDto = new UserDTO();
		userDto = convertToDTO(_user, userDto);
		result = userDto;
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
	@Transactional
	public List<UserDTO> assignExperiencesToUsers(Map<String, List<ExperienceDTO>> map) throws BusinessException {
		List<UserDTO> result = null;
		List<User> users = new ArrayList<User>();
		try {
			Object[] keys = map.keySet().toArray();
			for(int i=0 ; i < map.size(); i++) {
				List<MemberExperience> memberExperiences = new ArrayList<MemberExperience>();
				String key = String.valueOf(keys[i]);
				List<ExperienceDTO> experienceDTOs = map.get(key);
				_user = userDao.findById(Long.parseLong(key));
				users.add(_user);
				for(int j=0 ; j< experienceDTOs.size(); j++) {
					Experience experience = experienceDao.findById(experienceDTOs.get(j).getId());
					MemberExperience memberExperience = new MemberExperience();
					memberExperience.setExperience(experience);
					memberExperience.setMember(_user);
					memberExperiences.add(memberExperience);
				}
				_user.setMemberExperiences(memberExperiences);
			}
			
		result = users.stream().map(item -> convertToDTO(item, new UserDTO())).collect(Collectors.toList());
		
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
