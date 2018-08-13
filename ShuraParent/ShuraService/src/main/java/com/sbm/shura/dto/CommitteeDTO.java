package com.sbm.shura.dto;

import java.util.List;

public class CommitteeDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nameAr;

	private String nameEn;

	private UserDTO comManager;
	
	private List<CommitteeMemberDTO> commMembers;
	
	private List<CommitteeExperienceDTO> committeeExperiences;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id == 0)
			this.id = null;
		else
			this.id = id;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public UserDTO getComManager() {
		return comManager;
	}

	public void setComManager(UserDTO comManager) {
		this.comManager = comManager;
	}

	public List<CommitteeMemberDTO> getCommMembers() {
		return commMembers;
	}

	public void setCommMembers(List<CommitteeMemberDTO> commMembers) {
		this.commMembers = commMembers;
	}
	
	public List<CommitteeExperienceDTO> getCommitteeExperiences() {
		return committeeExperiences;
	}

	public void setCommitteeExperiences(List<CommitteeExperienceDTO> committeeExperiences) {
		this.committeeExperiences = committeeExperiences;
	}

}
