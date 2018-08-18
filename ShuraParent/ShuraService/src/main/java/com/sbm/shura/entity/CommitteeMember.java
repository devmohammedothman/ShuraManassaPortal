package com.sbm.shura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "COMMITTEEMEMBER")
@Entity
@NamedQueries(value = { @NamedQuery(name = "commMember.findAll", query = "select cm from CommitteeMember cm"),
		@NamedQuery(name = "commMember.findByUserId", query = "select cm from CommitteeMember cm where cm.member.userId =:userid"),
		@NamedQuery(name = "commMember.getCommAssignedMembers", query = "select cm from CommitteeMember cm where committee.id =:commId"),
		@NamedQuery(name = "commMember.deleteCommAssignedMembers", query = "delete from CommitteeMember cm where committee.id =:commId") })
public class CommitteeMember implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1780941928001523223L;

	@Id
	@Column(nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name = "commMember_ID_Generator", sequenceName = "COMMITTEEMEMBER_SEQ", initialValue = 1)
	@GeneratedValue(generator = "commMember_ID_Generator", strategy = GenerationType.SEQUENCE)
	private Long Id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MEMBERID", nullable = false)
	private User member;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMMITTEEID", nullable = false)
	private Committee committee;

	@Column(name = "WISHORDER", nullable = false)
	private int wishOrder;

	@Column(name = "ISAPPROVED", nullable = false)
	private boolean approved;

	public CommitteeMember() {
	}

	public CommitteeMember(Long Id) {
		this.Id = Id;
	}

	public Long getId() {
		return Id;
	}

	protected void setId(Long id) {
		this.Id = id;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public Committee getCommittee() {
		return committee;
	}

	public void setCommittee(Committee committee) {
		this.committee = committee;
	}

	public int getWishOrder() {
		return wishOrder;
	}

	public void setWishOrder(int wishOrder) {
		this.wishOrder = wishOrder;
	}

	public boolean getApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
