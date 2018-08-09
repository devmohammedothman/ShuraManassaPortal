package com.sbm.shura.dto;

public class CommitteeReqExperienceDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private CommitteeDTO committee;
	private ExperienceDTO experience;

	public CommitteeReqExperienceDTO(Long id) {
		this.id = id;
	}
	
	public CommitteeReqExperienceDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public CommitteeDTO getCommittee() {
	return committee;
	}

	public void setCommittee(CommitteeDTO committee) {
	this.committee = committee;
	}

	public ExperienceDTO getExperience() {
		return experience;
	}

	public void setExperience(ExperienceDTO experience) {
		this.experience = experience;
	}
	
}
