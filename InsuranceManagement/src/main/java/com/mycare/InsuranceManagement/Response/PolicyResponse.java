package com.mycare.InsuranceManagement.Response;

import java.util.List;
import com.mycare.InsuranceManagement.Model.InsurancePolicy;

public class PolicyResponse {
	int code;
	String status;
	boolean isSuccess;
	List<InsurancePolicy> data;

	public PolicyResponse() {

	}

	public PolicyResponse(int code, String status, boolean isSuccess, List<InsurancePolicy> data) {
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

	public List<InsurancePolicy> getData() {
		return data;
	}

	public void setData(List<InsurancePolicy> data) {
		this.data = data;
	}

	public static PolicyResponse isSuccess(int code, String status, boolean isSuccess, List<InsurancePolicy> data) {

		return new PolicyResponse(code, status, isSuccess, data);

	}
	
	public static PolicyResponse isFailed(int code, String status, boolean isSuccess) {

		return new PolicyResponse(code, status, isSuccess, null);

	}

	@Override
	public String toString() {
		return "PolicyResponse [code=" + code + ", status=" + status + ", isSuccess=" + isSuccess + ", data=" + data
				+ "]";
	}

}
