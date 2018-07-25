package com.sbm.shura.dto;

import com.sbm.shura.entity.User;

public class CommitteeDTO extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nameAr;
	
	private String nameEn;
	
	private User commManager;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public User getCommManager() {
		return commManager;
	}

	public void setCommManager(User commManager) {
		this.commManager = commManager;
	}

}
