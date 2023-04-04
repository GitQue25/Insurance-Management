package com.mycare.InsuranceManagement.DTO;

import java.time.LocalDate;


public class ClientDTO {
	
	private String name;
	private String dateOfBirth;
	private String address;
	private String contactInfo;
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
	@Override
	public String toString() {
		return "ClientDTO [name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", contactInfo="
				+ contactInfo + "]";
	}
	


}
