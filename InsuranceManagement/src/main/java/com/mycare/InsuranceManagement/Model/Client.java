package com.mycare.InsuranceManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;



@Entity
@Table(name = "client")

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int clientId;
	private String name;
	private String dateOfBirth;
	private String address;
	private String contactInfo;

	@ManyToOne
	@JoinColumn(name = "policy_no")
	@Nullable
	private InsurancePolicy policy;

	public Client() {
	}

	public Client(String name, String dateOfBirth, String address, String contactInfo) {		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactInfo = contactInfo;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public InsurancePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(InsurancePolicy policy) {
		this.policy = policy;
	}


	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", contactInfo=" + contactInfo + ", policy=" + policy + "]";
	}

}
