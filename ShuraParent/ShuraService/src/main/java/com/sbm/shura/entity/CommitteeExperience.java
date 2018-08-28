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

@Table (name = "COMMITTEE_EXPERIENCE")
@Entity
@NamedQueries (value = {
		@NamedQuery (name = "CommitteeExperience.findAll" , query = "select ce from CommitteeExperience ce")
})
public class CommitteeExperience implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8666877128575602425L;

	@Id
	@Column(insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name="COMMITTEEEXPERIENCE_ID_GENERATOR" , sequenceName = "committeeExperience_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMITTEEEXPERIENCE_ID_GENERATOR")
	private Long Id;
	
	@ManyToOne
	@JoinColumn (name = "COMMITTEE_ID", nullable = false)
	private Committee committee;
	
	@ManyToOne
	@JoinColumn(name = "EXPERIENCE_ID" , nullable = false)
	private Experience experience;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Committee getCommittee() {
		return committee;
	}

	public void setCommittee(Committee committee) {
		this.committee = committee;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	
}
