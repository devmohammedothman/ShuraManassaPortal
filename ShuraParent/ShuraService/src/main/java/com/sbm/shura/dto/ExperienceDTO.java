package com.sbm.shura.dto;


public class ExperienceDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nameAr;
	private String nameEn;
	private int exTypeId;

	public ExperienceDTO(Long id) {
		this.id = id;
	}
	
	public ExperienceDTO() {
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

	public int getExTypeId() {
		return exTypeId;
	}

	public void setExTypeId(int exTypeId) {
		this.exTypeId = exTypeId;
	}
}
