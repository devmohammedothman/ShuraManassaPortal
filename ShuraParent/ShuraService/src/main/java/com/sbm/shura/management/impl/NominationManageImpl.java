package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;
import com.sbm.shura.service.UserWishService;

@Component
public class NominationManageImpl implements NominationManage {

	@Autowired
	private UserWishService _userWishService;
		
	@Override
	public String addUserWish(List<UserWishDTO> list) {
		UserWishDTO wishObj = getUserWishesByUserIdAndCommitte(list.get(0).getNominatedUser().getUserId());
		if (wishObj.getId().equals(-1L)) {
			for (int i = 0; i < list.size(); i++) {
				_userWishService.addUserWish(list.get(i));
			}
			return "Done Added New";
		} else {
			_userWishService.deleteWish(list.get(0).getNominatedUser().getUserId());
			for (int i = 0; i < list.size(); i++) {
				_userWishService.addUserWish(list.get(i));
			}
			return "Done Updated";
		}
	}
	
	@Override
	public List<UserWishDTO> getUserWishList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserWishDTO getUserWishesByUserIdAndCommitte(long userId) {
		return _userWishService.getUserWishesByUserIdAndCommitte(userId);
	}

	@Override
	public String managerAssignUserWish(List<UserWishDTO> list) {
		UserWishDTO wishObj = getUserWishesByUserIdAndCommitte(list.get(0).getNominatedUser().getUserId());
		if (wishObj.getId().equals(-1L)) {
			for (int i = 0; i < list.size(); i++) {
				_userWishService.addUserWish(list.get(i));
			}
			return "Done Added New";
		} else {
			_userWishService.deleteWish(list.get(0).getNominatedUser().getUserId());
			for (int i = 0; i < list.size(); i++) {
				_userWishService.addUserWish(list.get(i));
			}
			return "Done Updated";
		}
	}

}
