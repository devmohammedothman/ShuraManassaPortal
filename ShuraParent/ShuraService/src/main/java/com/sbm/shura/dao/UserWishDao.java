package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.UserWish;

public interface UserWishDao extends GenericDao<UserWish> {
	
	public UserWish addUserWish(UserWish uw) throws RespositoryException;
	
	public List<UserWish> listUserWish() throws RespositoryException;
	
	public UserWish getUserWishesByUserIdAndCommitte(long userId) throws RespositoryException;
	
	public void deleteWish(long userId) throws RespositoryException;

}
