package com.sbm.shura.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.UserWishDao;
import com.sbm.shura.entity.UserWish;

@Repository
public class UserWishDaoImpl extends GenericDaoImpl<UserWish> implements UserWishDao {

	@Override
	public UserWish addUserWish(UserWish uw) throws RespositoryException {
		UserWish uwResult = null;
		try {
		uwResult =  persist(uw);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return uwResult;
	}

	@Override
	public List<UserWish> listUserWish() throws RespositoryException {
		List<UserWish> userWishList;
		try {
		userWishList = entityManager.createNamedQuery("userwish.findAll",UserWish.class).getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return userWishList;
	}

	@Override
	public UserWish getUserWishesByUserIdAndCommitte(long userId) throws RespositoryException {
		UserWish userWish = null;
		try {
			Query q = entityManager.createNamedQuery("userwish.findByUserId", UserWish.class);
			q.setParameter("userId", userId);
			userWish = (UserWish) q.getResultList().get(0);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return userWish;
	}
	
	@Override
	public void deleteWish(long userId) throws RespositoryException {
		try {
		Query q = entityManager.createQuery("delete from UserWish uw where uw.nominatedUser.userId = :userId");
		q.setParameter("userId", userId);
		q.executeUpdate();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
	}

}
