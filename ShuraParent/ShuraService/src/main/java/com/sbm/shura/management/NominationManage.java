package com.sbm.shura.management;

import java.util.List;

import com.sbm.shura.dto.UserWishDTO;

public interface NominationManage {
	
	UserWishDTO addUserWish(UserWishDTO userWishDto);
	
	List<UserWishDTO> getUserWishList();
	
}
