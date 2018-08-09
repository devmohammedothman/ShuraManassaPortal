package com.sbm.shura.dto;

public class MemberExperienceDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private ExperienceDTO experience;

	public MemberExperienceDTO(Long id) {
		this.id = id;
	}
	
	public MemberExperienceDTO() {
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