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
	
	private int shurianYear;
	
	private boolean isAssignedBySG ;
	

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

	public int getShurianYear() {
		return shurianYear;
	}

	public void setShurianYear(int shurianYear) {
		this.shurianYear = shurianYear;
	}

	public boolean isAssignedBySG() {
		return isAssignedBySG;
	}

	public void setAssignedBySG(boolean isAssignedBySG) {
		this.isAssignedBySG = isAssignedBySG;
	}

}