package com.sbm.shura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table (name = "MEMBER_EXPERIENCE")
@Entity
@NamedQueries (value = {
		@NamedQuery (name = "MemberExperience.findAll" , query = "select me from MemberExperience me")
})
public class MemberExperience {

	@Id
	@Column(insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name="MEMBEREXPERIENCE_ID_GENERATOR" , sequenceName = "memberExperience_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBEREXPERIENCE_ID_GENERATOR")
	private Long Id;
	
	@ManyToOne
	@JoinColumn (name = "MEMBER_ID", nullable = false)
	private User member;
	
	@ManyToOne
	@JoinColumn(name = "EXPERIENCE_ID" , nullable = false)
	private Experience experience;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}
}
