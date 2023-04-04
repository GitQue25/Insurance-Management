package com.mycare.InsuranceManagement.Response;

import java.util.List;

import com.mycare.InsuranceManagement.Model.Client;

public class ClientResponse {
	int code;
	String status;
	boolean isSuccess;
	List<Client> data;

	public ClientResponse() {

	}

	public ClientResponse(int code, String status, boolean isSuccess, List<Client> data) {
		super();
		this.code = code;
		this.status = status;
		this.isSuccess = isSuccess;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<Client> getData() {
		return data;
	}

	public void setData(List<Client> data) {
		this.data = data;
	}

	public static ClientResponse isSuccess(int code, String status, boolean isSuccess, List<Client> data) {

		return new ClientResponse(code, status, isSuccess, data);

	}
	
	public static ClientResponse isFailed(int code, String status, boolean isSuccess) {

		return new ClientResponse(code, status, isSuccess, null);

	}

	@Override
	public String toString() {
		return "ClientResponse [code=" + code + ", status=" + status + ", isSuccess=" + isSuccess + ", data=" + data
				+ "]";
	}

}
