package com.sbm.shura.dto;

public class WishDTO  extends BaseDTO{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 367830520652381512L;

	private CommitteeDTO wishedCommitee;
	
	private int wishOrder;
	
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
