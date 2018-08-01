package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.entity.UserWish;

public interface UserWishDao extends GenericDao<UserWish> {
	
	public UserWish addUserWish(UserWish uw);
	
	public List<UserWish> listUserWish();
	
	public UserWish getUserWishesByUserIdAndCommitte(long userId);
	
	public void deleteWish(long userId);

}
