package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.dto.UserWishDTO;

public interface NominationManage {
	
	String addUserWish(List<UserWishDTO> list);
	
	List<UserWishDTO> getUserWishList();
	
	public UserWishDTO getUserWishesByUserIdAndCommitte(long userId);
	
	String managerAssignUserWish(List<UserWishDTO> list);
}
