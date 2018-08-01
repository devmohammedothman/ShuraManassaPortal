<<<<<<< HEAD
package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.dao.UserWishDao;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.dto.WishDTO;
import com.sbm.shura.entity.Committee;
import com.sbm.shura.entity.UserWish;
import com.sbm.shura.service.UserWishService;

@Service

public class UserWishServiceImpl extends BasicServiceImpl<UserWishDTO, UserWish> implements UserWishService{

	@Autowired
	private UserWishDao _userWishDao;
	
	private UserWish _userWishObj;
	
	
	@Override
	@Transactional
	public UserWishDTO addUserWish(UserWishDTO uwdto) {

		
		
		for(WishDTO item : uwdto.getWishesList())
		{
			uwdto.setWishedCommitee(item.getWishedCommitee());
			uwdto.setWishOrder(item.getWishOrder());
			
			_userWishObj = new UserWish();
			
			_userWishObj = convertToEntity(_userWishObj, uwdto);
			
			Committee commObj = new Committee();
			commObj.setId(item.getWishedCommitee().getId());
			_userWishObj.setWishedCommitee(commObj);
			_userWishObj.setWishOrder(item.getWishOrder());
			_userWishDao.addUserWish(_userWishObj);
		}
		
		return uwdto;
		
	}

	@Override
	@Transactional
	public List<UserWishDTO> getUserWishList() {
		List<UserWish> userWishList = _userWishDao.listUserWish();
		List<UserWishDTO> userWishDtoList = userWishList.stream().
														map( item -> convertToDTO(item, new UserWishDTO()))
															.collect(Collectors.toList());
		return userWishDtoList;
	}

	@Override
	public List<CommitteeDTO> getUserWishesByUserId(long userId) {
		return null;
	}

	@Override
	public List<UserDTO> getCommitteeUserWishes(long committeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.dao.UserWishDao;
import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.entity.Committee;
import com.sbm.shura.entity.User;
import com.sbm.shura.entity.UserWish;
import com.sbm.shura.service.UserWishService;

@Service
@Transactional
public class UserWishServiceImpl extends BasicServiceImpl<UserWishDTO, UserWish> implements UserWishService{

	@Autowired
	private UserWishDao _userWishDao;
	
	private UserWish _userWishObj;
	
	
	@Override
	public UserWishDTO addUserWish(UserWishDTO uwdto) {

		_userWishObj = new UserWish();
		
		_userWishObj = convertToEntity(_userWishObj, uwdto);
		
		return convertToDTO(_userWishDao.addUserWish(_userWishObj), uwdto) ;
		
	}

	@Override
	public List<UserWishDTO> getUserWishList() {
		List<UserWish> userWishList = _userWishDao.listUserWish();
		List<UserWishDTO> userWishDtoList = userWishList.stream().
														map( item -> convertToDTO(item, new UserWishDTO()))
															.collect(Collectors.toList());
		return userWishDtoList;
	}

	@Override
	public UserWishDTO getUserWishesByUserIdAndCommitte(long userId) {
		return convertToDTO(_userWishDao.getUserWishesByUserIdAndCommitte(userId), new UserWishDTO());
	}

	@Override
	public List<UserDTO> getCommitteeUserWishes(long committeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWish(long userId) {
		_userWishDao.deleteWish(userId);
	}

}
>>>>>>> branch 'ftb-basestarterfeatures' of https://github.com/sbm-mohammedothman/ShuraManassaPortal.git
