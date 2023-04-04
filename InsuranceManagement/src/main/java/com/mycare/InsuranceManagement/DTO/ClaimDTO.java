package com.mycare.InsuranceManagement.DTO;

import java.time.LocalDate;

import javax.persistence.Column;

public class ClaimDTO {
	

	private String claimDiscription;
	private String claimDate;
	private String claimStatus;


	public String getClaimDiscription() {
		return claimDiscription;
	}
	public void setClaimDiscription(String claimDiscription) {
		this.claimDiscription = claimDiscription;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	@Override
	public String toString() {
		return "ClaimDTO [claimDiscription=" + claimDiscription + ", claimDate=" + claimDate + ", claimStatus="
				+ claimStatus + "]";
	}

	
	
}
