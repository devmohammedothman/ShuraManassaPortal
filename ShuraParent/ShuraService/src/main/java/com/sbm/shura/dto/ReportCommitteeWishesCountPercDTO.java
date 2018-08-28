package com.sbm.shura.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReportCommitteeWishesCountPercDTO {
	
	private List<ReportCommitteeWishesCountDTO> reportCommitteeWishesCount;
	private BigDecimal firstWishCountTotal;
	private BigDecimal secondWishCountTotal;
	private BigDecimal thirdWishCountTotal;
	private BigDecimal totalWishCountTotal;
	private double firstWishCountPerc;
	private double secondWishCountPerc;
	private double thirdWishCountPerc;
	private double totalWishCountPerc;
	
	public ReportCommitteeWishesCountPercDTO() {
		this.setReportCommitteeWishesCount(new ArrayList<ReportCommitteeWishesCountDTO>());
	}
	
	public BigDecimal getFirstWishCountTotal() {
		return firstWishCountTotal;
	}
	public void setFirstWishCountTotal(BigDecimal firstWishCountTotal) {
		this.firstWishCountTotal = firstWishCountTotal;
	}
	public BigDecimal getSecondWishCountTotal() {
		return secondWishCountTotal;
	}
	public void setSecondWishCountTotal(BigDecimal secondWishCountTotal) {
		this.secondWishCountTotal = secondWishCountTotal;
	}
	public BigDecimal getThirdWishCountTotal() {
		return thirdWishCountTotal;
	}
	public void setThirdWishCountTotal(BigDecimal thirdWishCountTotal) {
		this.thirdWishCountTotal = thirdWishCountTotal;
	}
	public BigDecimal getTotalWishCountTotal() {
		return totalWishCountTotal;
	}
	public void setTotalWishCountTotal(BigDecimal totalWishCountTotal) {
		this.totalWishCountTotal = totalWishCountTotal;
	}
	public double getFirstWishCountPerc() {
		return firstWishCountPerc;
	}
	public void setFirstWishCountPerc(double firstWishCountPerc) {
		this.firstWishCountPerc = firstWishCountPerc;
	}
	public double getSecondWishCountPerc() {
		return secondWishCountPerc;
	}
	public void setSecondWishCountPerc(double secondWishCountPerc) {
		this.secondWishCountPerc = secondWishCountPerc;
	}
	public double getThirdWishCountPerc() {
		return thirdWishCountPerc;
	}
	public void setThirdWishCountPerc(double thirdWishCountPerc) {
		this.thirdWishCountPerc = thirdWishCountPerc;
	}
	public double getTotalWishCountPerc() {
		return totalWishCountPerc;
	}
	public void setTotalWishCountPerc(double totalWishCountPerc) {
		this.totalWishCountPerc = totalWishCountPerc;
	}

	public List<ReportCommitteeWishesCountDTO> getReportCommitteeWishesCount() {
		return reportCommitteeWishesCount;
	}

	public void setReportCommitteeWishesCount(List<ReportCommitteeWishesCountDTO> reportCommitteeWishesCount) {
		this.reportCommitteeWishesCount = reportCommitteeWishesCount;
	}
}
