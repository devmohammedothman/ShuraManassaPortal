package com.sbm.shura.dto;

import com.sbm.shura.entity.User;

public class CommitteeDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nameAr;

	private String nameEn;

	private UserDTO commManager;

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

	public UserDTO getCommManager() {
		return commManager;
	}

	public void setCommManager(UserDTO commManager) {
		this.commManager = commManager;
	}

}
