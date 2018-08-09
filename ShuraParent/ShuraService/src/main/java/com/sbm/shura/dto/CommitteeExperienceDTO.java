package com.sbm.shura.dto;

public class CommitteeExperienceDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private ExperienceDTO experience;

	public CommitteeExperienceDTO(Long id) {
		this.id = id;
	}
	
	public CommitteeExperienceDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExperienceDTO getExperience() {
		return experience;
	}

	public void setExperience(ExperienceDTO experience) {
		this.experience = experience;
	}
	
}