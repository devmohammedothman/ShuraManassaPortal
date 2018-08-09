package com.sbm.shura.dto;

public class CommitteeMemberDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8842389329399315542L;
	
	public CommitteeMemberDTO() {}

	public CommitteeMemberDTO(UserDTO member,CommitteeDTO committee,int wishOrder)
	{
		this.member = member;
		
		this.committee = committee;
		
		this.wishOrder = wishOrder;
	}
	
	private Long Id;
	
	private UserDTO member;
	
	private CommitteeDTO committee;
	
	private int wishOrder;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public UserDTO getMember() {
		return member;
	}

	public void setMember(UserDTO member) {
		this.member = member;
	}

	public CommitteeDTO getCommittee() {
		return committee;
	}

	public void setCommittee(CommitteeDTO committee) {
		this.committee = committee;
	}

	public int getWishOrder() {
		return wishOrder;
	}

	public void setWishOrder(int wishOrder) {
		this.wishOrder = wishOrder;
	}
	
	
}
