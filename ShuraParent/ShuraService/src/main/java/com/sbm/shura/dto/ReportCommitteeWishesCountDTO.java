package com.sbm.shura.dto;

import java.math.BigDecimal;

public class ReportCommitteeWishesCountDTO {
	
	private String committeeName;
	private BigDecimal firstWishCount;
	private BigDecimal secondWishCount;
	private BigDecimal thirdWishCount;
	private BigDecimal totalWishCount;
	
	public String getCommitteeName() {
		return committeeName;
	}
	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}
	public BigDecimal getFirstWishCount() {
		return firstWishCount;
	}
	public void setFirstWishCount(BigDecimal firstWishCount) {
		this.firstWishCount = firstWishCount;
	}
	public BigDecimal getSecondWishCount() {
		return secondWishCount;
	}
	public void setSecondWishCount(BigDecimal secondWishCount) {
		this.secondWishCount = secondWishCount;
	}
	public BigDecimal getThirdWishCount() {
		return thirdWishCount;
	}
	public void setThirdWishCount(BigDecimal thirdWishCount) {
		this.thirdWishCount = thirdWishCount;
	}
	public BigDecimal getTotalWishCount() {
		return totalWishCount;
	}
	public void setTotalWishCount(BigDecimal totalWishCount) {
		this.totalWishCount = totalWishCount;
	}
	
}
