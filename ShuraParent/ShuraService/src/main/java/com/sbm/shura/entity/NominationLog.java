package com.sbm.shura.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table (name = "NOMINTATIONLOG")
@Entity
@NamedQueries(value = { @NamedQuery(name = "nomLog.findAll", query = "select nl from NominationLog nl")
						})
public class NominationLog {

	
	@Id
	@Column(insertable = true, nullable = false, unique = true, updatable = false)
	@SequenceGenerator(name = "nomLog_ID_Generator", sequenceName = "NOMINTATIONLOG_SEQ", initialValue = 1)
	@GeneratedValue(generator = "nomLog_ID_Generator", strategy = GenerationType.SEQUENCE)
	private Long Id;
	
	@Column (name = "NOOFMEMBERS",nullable = false)
	private int noOfMembers;
	
	@Column (name = "ACTIONNO" , nullable = false)
	private int actionNo;
	
	//Default 1 is true and 0 is false
	@Column (name = "ISAPPROVED" , nullable = false , columnDefinition="number(1) default 1")
	private boolean isApproved;
	
	
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name = "RUNDATE", nullable = true, updatable = false , columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date runDate = new Date();
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "actionUserId", nullable = false)
	private User actionUser;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

}
