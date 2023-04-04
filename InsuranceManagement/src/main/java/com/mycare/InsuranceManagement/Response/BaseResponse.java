package com.mycare.InsuranceManagement.Response;

public class BaseResponse {

	int code;
	String status;
	boolean isSuccess;

	public BaseResponse() {

	}

	public BaseResponse(int code, String status, boolean isSuccess) {
		this.code = code;
		this.status = status;
		this.isSuccess = isSuccess;
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

	public static BaseResponse isSuccessOrFailed(int code, String status, boolean isSuccess) {
	
		return new BaseResponse(code, status, isSuccess);

	}



}
