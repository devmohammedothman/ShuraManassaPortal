package com.sbm.shura.dto;

public class CommitteeMemberDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8842389329399315542L;

	public CommitteeMemberDTO() {
	}

	public CommitteeMemberDTO(UserDTO member, CommitteeDTO committee, int wishOrder, boolean approved) {
		this.member = member;

		this.committee = committee;

		this.wishOrder = wishOrder;

		this.approved = approved;
	}

	private Long Id;

	private UserDTO member;

	private CommitteeDTO committee;

	private int wishOrder;

	private boolean approved;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		if (id == null || id == 0)
			this.Id = null;
		else
			this.Id = id;
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

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
