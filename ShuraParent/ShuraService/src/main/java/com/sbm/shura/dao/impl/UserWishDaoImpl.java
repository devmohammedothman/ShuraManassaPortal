package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

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

	@Override
	public UserWish getUserWishesByUserIdAndCommitte(long userId) {
		try {
			Query q = entityManager.createNamedQuery("userwish.findByUserId", UserWish.class);
			q.setParameter("userId", userId);
			return (UserWish) q.getResultList().get(0);
		} catch (Exception e) {
			return new UserWish(-1L);
		}
	}
	
	@Override
	public void deleteWish(long userId) {
		Query q = entityManager.createQuery("delete from UserWish uw where uw.nominatedUser.userId = :userId");
		q.setParameter("userId", userId);
		q.executeUpdate();
	}

}
