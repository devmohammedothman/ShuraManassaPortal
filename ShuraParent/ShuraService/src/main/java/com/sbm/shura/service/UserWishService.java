package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.dto.UserWishDTO;

public interface UserWishService {
	
	UserWishDTO addUserWish(UserWishDTO uwdto);
	
	List<UserWishDTO> getUserWishList();
	
	List<CommitteeDTO> getUserWishesByUserId(long userId);
	
	List<UserDTO> getCommitteeUserWishes(long committeeId);

}
