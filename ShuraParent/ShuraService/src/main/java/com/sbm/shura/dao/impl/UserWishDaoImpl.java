package com.sbm.shura.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.shura.dao.UserWishDao;
import com.sbm.shura.entity.UserWish;

@Repository
public class UserWishDaoImpl extends GenericDaoImpl<UserWish> implements UserWishDao {

	@Override
	public UserWish addUserWish(UserWish uw) {
		UserWish uwResult =  persist(uw);
		return uwResult;
	}

	@Override
	public List<UserWish> listUserWish() {
		// TODO Auto-generated method stub
		List<UserWish> userWishList = entityManager.createNamedQuery("userwish.findAll",UserWish.class).getResultList();
		return userWishList;
	}

}
