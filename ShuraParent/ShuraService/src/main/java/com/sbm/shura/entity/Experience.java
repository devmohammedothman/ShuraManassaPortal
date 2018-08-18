package com.sbm.shura.entity;

import javax.persistence.*;

@Table(name = "EXPERIENCE")
@Entity
@NamedQueries(value = { @NamedQuery(name = "Experience.findAll", query = "select e from Experience e"),
		@NamedQuery(name = "Experience.findById", query = "select e from Experience e where e.id = :experienceId"),
		@NamedQuery(name = "Experience.findByNameEn", query = "SELECT e FROM Experience e WHERE e.nameEn = :nameEn") 
})
public class Experience implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name="EXPERIENCE_ID_GENERATOR" , sequenceName = "experience_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXPERIENCE_ID_GENERATOR")
	private Long id;

	@Column(name = "Name_AR", insertable = true, length = 50, nullable = true, unique = false, updatable = true)
	private String nameAr;

	@Column(name = "NAME_EN", insertable = true, length = 45, nullable = true, unique = false, updatable = true)
	private String nameEn;

	@Column(name = "TYPEID" , nullable = false)
	private int exTypeId;
	
	
	public Experience(Long id) {
		super();
		this.id = id;
	}

	public Experience() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setNameAr(java.lang.String nameAr) {
		this.nameAr = nameAr;
	}

	public java.lang.String getNameAr() {
		return this.nameAr;
	}

	public void setNameEn(java.lang.String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public int getExTypeId() {
		return exTypeId;
	}

	public void setExTypeId(int exTypeId) {
		this.exTypeId = exTypeId;
	}

}
