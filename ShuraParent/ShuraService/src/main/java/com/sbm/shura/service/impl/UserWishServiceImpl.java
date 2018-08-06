package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.UserWishDao;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.entity.UserWish;
import com.sbm.shura.service.UserWishService;

@Service
@Transactional
public class UserWishServiceImpl extends BasicServiceImpl<UserWishDTO, UserWish> implements UserWishService{

	@Autowired
	private UserWishDao _userWishDao;
	
	private UserWish _userWishObj;
	
	
//	@Override
//	protected void configureMapperLocally() {
//		modelMapper.addMappings(new PropertyMap<UserWish, UserWishDTO>() {
//			protected void configure() {
//				map().getNominatedUser().setUserId(source.getId());;
//			}
//		});
//	}

	@Override
	public UserWishDTO addUserWish(UserWishDTO uwdto) throws BusinessException {
		UserWishDTO result = null;
		try {
		_userWishObj = new UserWish();
		
		_userWishObj = convertToEntity(_userWishObj, uwdto);
		
		result = convertToDTO(_userWishDao.addUserWish(_userWishObj), uwdto) ;
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
	public List<UserWishDTO> getUserWishList() throws BusinessException {
		List<UserWishDTO> result;
		try {
		List<UserWish> userWishList = _userWishDao.listUserWish();
		List<UserWishDTO> userWishDtoList = userWishList.stream().
														map( item -> convertToDTO(item, new UserWishDTO()))
															.collect(Collectors.toList());
		result = userWishDtoList;
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
	public UserWishDTO getUserWishesByUserIdAndCommitte(long userId) throws BusinessException {
		UserWishDTO result = null;
		try {
			result = convertToDTO(_userWishDao.getUserWishesByUserIdAndCommitte(userId), new UserWishDTO());
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
	public List<UserDTO> getCommitteeUserWishes(long committeeId) throws BusinessException {
		List<UserDTO> result = null;
//		try {
//			
//		}catch (RespositoryException e) {
//			e.printStackTrace();
//			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
//		}
		return result;
	}

	@Override
	public void deleteWish(long userId) throws BusinessException {
		try {
		_userWishDao.deleteWish(userId);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
	}

}