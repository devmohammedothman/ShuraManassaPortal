package com.sbm.shura.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6444194046565746920L;

	/** The id. */
	protected long id;

	/** The name. */
	protected String name;

	/** The name. */
	protected String nameEn;

	protected String nameAr;
    
	protected Date CreationDate;
	
	public BaseDTO() {}
	
	public BaseDTO(long id , String name) 
	{
		this.id = id;
		this.name = name;
	}
	
	public BaseDTO(long id , String name,String nameAr, String nameEn) 
	{
		this.id = id;
		this.name = name;
		this.nameAr = nameAr;
		this.nameEn = nameEn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	
}
