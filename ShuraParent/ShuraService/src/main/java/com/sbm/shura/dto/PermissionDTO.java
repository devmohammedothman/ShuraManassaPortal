package com.sbm.shura.dto;

public class PermissionDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5890191532300522155L;

	private long id;
	private int code;
	private String nameAr;
	private String nameEn;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
