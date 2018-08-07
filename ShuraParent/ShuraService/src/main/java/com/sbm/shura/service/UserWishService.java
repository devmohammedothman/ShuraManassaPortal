package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.dto.UserWishDTO;

public interface UserWishService {
	
	UserWishDTO addUserWish(UserWishDTO uwdto) throws BusinessException;
		
	List<UserWishDTO> getUserWishList() throws BusinessException;
	
	List<UserWishDTO> getCurrentHijriiYearUserWishList(String shurianYear) throws BusinessException;
	
	UserWishDTO getUserWishesByUserIdAndCommitte(long userId) throws BusinessException;
	
	List<UserDTO> getCommitteeUserWishes(long committeeId) throws BusinessException;
		
	public void deleteWish(long userId) throws BusinessException;

}
