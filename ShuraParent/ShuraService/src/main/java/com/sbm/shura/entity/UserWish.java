package com.sbm.shura.entity;

import javax.persistence.*;

@Table (name ="USERWISH")
@Entity
@NamedQueries (value = {
		@NamedQuery (name = "userwish.findAll",query = "select uw from UserWish uw")
})
public class UserWish {
	
	@Id
	@Column (insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name = "userwish_ID_Generator", sequenceName = "usrwish_seq")
    @GeneratedValue(generator = "userwish_ID_Generator", strategy = GenerationType.SEQUENCE)
	private Integer Id;
	
	@ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn (name = "COMMITTEEID" , nullable = false)
	private Committee wishedCommitee;

	@Column (name = "WISHORDER" , nullable = false)
	private int wishOrder;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "NOMINATEDUSERID")
	private User nominatedUser;

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

}