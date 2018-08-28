package com.sbm.shura.dto;

import com.sbm.shura.commonlib.utilities.HijriDateConverter;

public class UserWishDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	
	private UserDTO nominatedUser;
		
	private CommitteeDTO wishedCommitee;
	
	private int wishOrder;
	
	private int shurianYear = HijriDateConverter.convertCurrentDateToHijri().getYear();
	
	private boolean isAssignedBySG ;
	
	private String memberNotes;
	

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

	public String getMemberNotes() {
		return memberNotes;
	}

	public void setMemberNotes(String memberNotes) {
		this.memberNotes = memberNotes;
	}

}