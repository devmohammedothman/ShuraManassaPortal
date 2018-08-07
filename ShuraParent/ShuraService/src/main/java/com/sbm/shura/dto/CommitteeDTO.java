package com.sbm.shura.dto;

import java.util.List;

import com.sbm.shura.entity.User;

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

	public CommitteeDTO(Long id) {
		this.id = id;
	}
	
	public CommitteeDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
