package com.sbm.shura.entity;

import java.util.Date;

import javax.persistence.*;

@Table(name = "USERWISH")
@Entity
@NamedQueries(value = { @NamedQuery(name = "userwish.findAll", query = "select uw from UserWish uw"),
		@NamedQuery(name = "userwish.findByUserId", query = "select uw from UserWish uw where uw.nominatedUser.userId = :userId"),
		@NamedQuery(name = "userwish.findByshurianYear", query = "select uw from UserWish uw where uw.shurianYear = :shurianYear"),
		@NamedQuery(name= "userwish.deleteByUserId", query= "delete from UserWish uw where uw.nominatedUser.userId = :userId")})
public class UserWish {

	@Id
	@Column(insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name = "userwish_ID_Generator", sequenceName = "usrwish_seq", initialValue = 1)
	@GeneratedValue(generator = "userwish_ID_Generator", strategy = GenerationType.SEQUENCE)
	private Long Id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMMITTEEID", nullable = false)
	private Committee wishedCommitee;

	@Column(name = "WISHORDER", nullable = false)
	private int wishOrder;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NOMINATEDUSERID" , nullable = false)
	private User nominatedUser;
	
	@Column (name = "SHURIANYEAR" , nullable = false)
	private int shurianYear;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSERTIONDATE", nullable = true, updatable = false , columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date insertionDate = new Date();
	
	//default is false = 0
	@Column (name = "ISASSIGNEDBYSG" , nullable = true , columnDefinition="number(1) default 0" )
	private boolean isAssignedBySG ;

	public UserWish(Long id) {
		Id = id;
	}

	public UserWish() {
	}

	public Committee getWishedCommitee() {
		return wishedCommitee;
	}

	public void setWishedCommitee(Committee wishedCommitee) {
		this.wishedCommitee = wishedCommitee;
	}

	public int getWishOrder() {
		return wishOrder;
	}

	public void setWishOrder(int wishOrder) {
		this.wishOrder = wishOrder;
	}

	public User getNominatedUser() {
		return nominatedUser;
	}

	public void setNominatedUser(User nominatedUser) {
		this.nominatedUser = nominatedUser;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getShurianYear() {
		return shurianYear;
	}

	public void setShurianYear(int shurianYear) {
		this.shurianYear = shurianYear;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

}
