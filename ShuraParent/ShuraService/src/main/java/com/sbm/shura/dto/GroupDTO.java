package com.sbm.shura.dto;

import java.util.List;

public class GroupDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1034244955255880474L;
	
	
	private String description;
	private boolean isActive;
	private String nameAr;
	private String nameEn;
	private List<PermissionDTO> permissions;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public List<PermissionDTO> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionDTO> permission) {
		this.permissions = permission;
	}
	
	

}
