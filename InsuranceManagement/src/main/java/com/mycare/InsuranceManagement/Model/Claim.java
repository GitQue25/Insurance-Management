package com.mycare.InsuranceManagement.Model;

import javax.persistence.Column;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mycare.InsuranceManagement.Response.BaseResponse;

@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "claim_no")
	private int claimNo;
	private String claimDate;
	private String claimStatus;
	private String claimDiscription;

	@OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
	private InsurancePolicy data;

	
	public Claim() {}
	public Claim( String claimDate, String claimStatus, String claimDiscription) {

		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.claimDiscription = claimDiscription;
	}


	public int getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(int claimNo) {
		this.claimNo = claimNo;
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

	public InsurancePolicy getData() {
		return data;
	}

	public void setData(InsurancePolicy data) {
		this.data = data;
	}

	public String getClaimDiscription() {
		return claimDiscription;
	}

	public void setClaimDiscription(String claimDiscription) {
		this.claimDiscription = claimDiscription;
	}
	@Override
	public String toString() {
		return "Claim [claimNo=" + claimNo + ", claimDate=" + claimDate + ", claimStatus=" + claimStatus
				+ ", claimDiscription=" + claimDiscription + ", data=" + data + "]";
	}



}
