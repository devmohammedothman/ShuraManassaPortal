package com.sbm.shura.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.shura.dao.GroupDao;
import com.sbm.shura.dao.UserDao;
import com.sbm.shura.dto.GroupDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.entity.Group;
import com.sbm.shura.entity.User;
import com.sbm.shura.service.GroupService;
import com.sbm.shura.service.UserService;

@Service
public class UserServiceImpl extends BasicServiceImpl<UserDTO, User> implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private GroupDao groupDao;

	private User _user = new User();

	public UserServiceImpl() {
	}

	@Override
	@Transactional
	public UserDTO add(UserDTO userDto, String groupName) {
		_user = new User();
		_user = convertToEntity(_user, userDto);
		_user = userDao.add(_user);
		if (!stringIsBlank(groupName)) {
			try {
				assignGroupToUser(groupName, _user.getEmail());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return convertToDTO(_user, userDto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> listUsers() {
		List<User> userListResult = userDao.listUsers();
		List<UserDTO> userDtoList = userListResult.stream().map(item -> convertToDTO(item, new UserDTO()))
				.collect(Collectors.toList());
		return userDtoList;

	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO login(String email, String password) {

		_user = userDao.login(email, password);
		if (_user == null) {
			return new UserDTO(-1L);
		}
		UserDTO userDto = new UserDTO();
		userDto = convertToDTO(_user, userDto);
		return userDto;
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
	public UserDTO findByEmail(String email) {
		_user = userDao.findByEmail(email);
		if (_user == null) {
			return new UserDTO(-1L);
		}
		UserDTO userDto = new UserDTO();
		userDto = convertToDTO(_user, userDto);
		return userDto;
	}

	@Override
	@Transactional
	public UserDTO assignGroupToUser(String groupName, String email) throws Exception {
		UserDTO userDto = findByEmail(email);

		// GroupDTO groupDto = groupService.getByEName(groupName);

		Group group = groupDao.getByEName(groupName);

		// groupDto.getUsers().add(userDto);

		_user = userDao.findById(userDto.getId());
		group = groupDao.findById(group.getId());
		if (_user.getGroups() == null) {
			_user.setGroups(new ArrayList<Group>());
			_user.getGroups().add(group);
		} else {
		    _user.getGroups().add(group);
		}
		group.getUsers().add(_user);

		// _user = userDao.update(_user);

		return convertToDTO(_user, userDto);
	}

	@Override
	@Transactional
	public UserDTO findById(long userId) {
				
		_user = userDao.findById(userId);
		
		UserDTO userDto = new UserDTO();
		userDto = convertToDTO(_user, userDto);
		return userDto;
	}

}
