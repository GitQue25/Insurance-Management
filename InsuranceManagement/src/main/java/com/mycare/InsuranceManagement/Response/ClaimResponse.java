package com.mycare.InsuranceManagement.Response;

import java.util.List;

import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Model.Client;

public class ClaimResponse {

	int code;
	String status;
	boolean isSuccess;
	List<Claim> data;

	public ClaimResponse() {

	}

	public ClaimResponse(int code, String status, boolean isSuccess, List<Claim> data) {
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

	public List<Claim> getData() {
		return data;
	}

	public void setData(List<Claim> data) {
		this.data = data;
	}

	public static ClaimResponse isSuccess(int code, String status, boolean isSuccess, List<Claim> data) {

		return new ClaimResponse(code, status, isSuccess, data);

	}
	
	public static ClaimResponse isFailed(int code, String status, boolean isSuccess) {

		return new ClaimResponse(code, status, isSuccess, null);

	}

	@Override
	public String toString() {
		return "ClaimResponse [code=" + code + ", status=" + status + ", isSuccess=" + isSuccess + ", data=" + data
				+ "]";
	}

}
