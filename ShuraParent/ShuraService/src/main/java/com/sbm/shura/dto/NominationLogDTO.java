package com.sbm.shura.dto;

public class NominationLogDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3692989912096826194L;
	
	private Long Id;
	
	private int noOfMembers;
	
	private int actionNo;
	
	private boolean isApproved ;
	
	private UserDTO actionUser;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}

	public int getActionNo() {
		return actionNo;
	}

	public void setActionNo(int actionNo) {
		this.actionNo = actionNo;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public UserDTO getActionUser() {
		return actionUser;
	}

	public void setActionUser(UserDTO actionUser) {
		this.actionUser = actionUser;
	}
	
	
	
	

}
