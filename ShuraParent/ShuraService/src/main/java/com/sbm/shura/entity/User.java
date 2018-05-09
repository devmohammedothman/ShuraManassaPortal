package com.sbm.shura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
		@NamedQuery(name = "User.findByEmailAndPassword", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password") })
public class User extends BaseEntity {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "user_seq")
	private Long userId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	public User() {
	}

	public User(Long userId) {
		this.userId = userId;
	}

	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
