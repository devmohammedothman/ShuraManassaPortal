<<<<<<< HEAD
package com.sbm.shura.dto;

public class UserWishDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	
	private UserDTO nominatedUser;
	
	private WishDTO [] wishesList;
	
	private CommitteeDTO wishedCommitee;
	
	private int wishOrder;
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public UserDTO getNominatedUser() {
		return nominatedUser;
	}

	public void setNominatedUser(UserDTO nominatedUser) {
		this.nominatedUser = nominatedUser;
	}

	public WishDTO [] getWishesList() {
		return wishesList;
	}

	public void setWishesList(WishDTO [] wishesList) {
		this.wishesList = wishesList;
	}

	public CommitteeDTO getWishedCommitee() {
		return wishedCommitee;
	}

	public void setWishedCommitee(CommitteeDTO wishedCommitee) {
		this.wishedCommitee = wishedCommitee;
	}

	public int getWishOrder() {
		return wishOrder;
	}

	public void setWishOrder(int wishOrder) {
		this.wishOrder = wishOrder;
	}

}
=======
package com.sbm.shura.dto;

import com.sbm.shura.entity.Committee;
import com.sbm.shura.entity.User;

public class UserWishDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long Id;
	
	private UserDTO nominatedUser;
	
	private CommitteeDTO wishedCommitee;
	
	private int wishOrder;
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public UserDTO getNominatedUser() {
		return nominatedUser;
	}

	public void setNominatedUser(UserDTO nominatedUser) {
		this.nominatedUser = nominatedUser;
	}

	public CommitteeDTO getWishedCommitee() {
		return wishedCommitee;
	}

	public void setWishedCommitee(CommitteeDTO wishedCommitee) {
		this.wishedCommitee = wishedCommitee;
	}

	public int getWishOrder() {
		return wishOrder;
	}

	public void setWishOrder(int wishOrder) {
		this.wishOrder = wishOrder;
	}

}
>>>>>>> branch 'ftb-basestarterfeatures' of https://github.com/sbm-mohammedothman/ShuraManassaPortal.git
