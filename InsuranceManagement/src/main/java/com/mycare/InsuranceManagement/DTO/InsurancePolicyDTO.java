package com.mycare.InsuranceManagement.DTO;

import java.time.LocalDate;

import javax.persistence.Column;

public class InsurancePolicyDTO {

	private String type;
	private String coverageAmt;
	private String premium;
	private String startDate;
	private String endDate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCoverageAmt() {
		return coverageAmt;
	}

	public void setCoverageAmt(String coverageAmt) {
		this.coverageAmt = coverageAmt;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "InsurancePolicyDTO [type=" + type + ", coverageAmt=" + coverageAmt + ", premium=" + premium
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
