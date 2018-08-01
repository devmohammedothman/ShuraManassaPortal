package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.dto.UserWishDTO;

public interface NominationManage {
	
	UserWishDTO addUserWish(long userId, long committeId,long wishOrder);
	
	List<UserWishDTO> getUserWishList();
	
	public UserWishDTO getUserWishesByUserIdAndCommitte(long userId);
	
	String managerAssignUserWish(List<UserWishDTO> list);
}
