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

@Table (name = "COMMITTEEMEMBER")
@Entity
@NamedQueries (value = {
		@NamedQuery (name = "commMember.findAll" , query = "select cm from CommitteeMember cm")
})
public class CommitteeMember {

	@Id
	@Column(insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name = "commMember_ID_Generator", sequenceName = "COMMITTEEMEMBER_SEQ", initialValue = 1)
	@GeneratedValue(generator = "commMember_ID_Generator", strategy = GenerationType.SEQUENCE)
	private Long Id;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "MEMBERID" , nullable = false)
	private User member;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "COMMITTEEID", nullable = false)
	private Committee committee;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
	
}