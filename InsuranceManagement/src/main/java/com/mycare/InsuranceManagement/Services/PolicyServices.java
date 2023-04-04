package com.mycare.InsuranceManagement.Services;

import java.util.List;

import com.mycare.InsuranceManagement.DTO.InsurancePolicyDTO;
import com.mycare.InsuranceManagement.Model.InsurancePolicy;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.PolicyResponse;

public interface PolicyServices {

	BaseResponse updatePolicy(int id,InsurancePolicyDTO policy);

	PolicyResponse getAllPolicies();

	PolicyResponse getPolicyById(int id);

	BaseResponse createPolicy(InsurancePolicyDTO policy);

	BaseResponse deletePolicy(int id);

}
