package com.mycare.InsuranceManagement.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mycare.InsuranceManagement.Response.BaseResponse;
import javax.persistence.Column;
@Entity
@Table(name = "insurance_policy")
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="policy_no")
	private int policyNo;
	private String type;
	private String coverageAmt;
	private String premium;

	private String startDate;
	private String endDate;

	// many client
	@OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
	private List<Client> client;

	// one to one
	@OneToOne
	@JoinColumn(name = "claim_no")
	private Claim claim;

	
	public InsurancePolicy() {}
	
	
	public InsurancePolicy( String type, String coverageAmt, String premium,
			String startDate, String endDate) {

		this.type = type;
		this.coverageAmt = coverageAmt;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public int getPolicyNo() {
		return policyNo;
	}


	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}


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


	public List<Client> getClient() {
		return client;
	}


	public void setClient(List<Client> client) {
		this.client = client;
	}


	public Claim getClaim() {
		return claim;
	}


	public void setClaim(Claim claim) {
		this.claim = claim;
	}


	@Override
	public String toString() {
		return "InsurancePolicy [policyNo=" + policyNo + ", type=" + type + ", coverageAmt=" + coverageAmt
				+ ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate + ", client=" + client
				+ ", claim=" + claim + "]";
	}




}
