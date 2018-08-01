package com.sbm.shura.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sbm.shura.dto.CommitteeDTO;
import com.sbm.shura.dto.UserDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;
import com.sbm.shura.service.CommitteeService;
import com.sbm.shura.service.UserService;
import com.sbm.shura.service.UserWishService;
import static java.lang.Math.toIntExact;

@Component
public class NominationManageImpl implements NominationManage {
	
	@Autowired
	private UserWishService _userWishService;
	
	@Autowired
	private UserService _userService;
	
	@Autowired
	private CommitteeService _committeeService;

	@Override
	public UserWishDTO addUserWish(UserWishDTO userWishDto) {
		
		//validate User Object is in member Group
		
		
		/*GroupDTO groupDto =  uwdto.getNominatedUser().getGroups().stream().
				filter( item -> item.getNameEn().equals("ADMIN")).findFirst().get();
		if(groupDto != null)*/
			return _userWishService.addUserWish(userWishDto);
//		 return null; 
	}

	@Override
	public List<UserWishDTO> getUserWishList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
