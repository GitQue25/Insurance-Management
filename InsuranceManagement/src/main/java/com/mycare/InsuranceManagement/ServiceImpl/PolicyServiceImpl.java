package com.mycare.InsuranceManagement.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycare.InsuranceManagement.DTO.InsurancePolicyDTO;
import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Model.InsurancePolicy;
import com.mycare.InsuranceManagement.Repositories.PolicyRepo;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClientResponse;
import com.mycare.InsuranceManagement.Response.PolicyResponse;
import com.mycare.InsuranceManagement.Services.PolicyServices;

@Service
public class PolicyServiceImpl implements PolicyServices {
	@Autowired
	PolicyRepo repo;

	@Override
	public PolicyResponse getAllPolicies() {
		try {
			List<InsurancePolicy> res = repo.findAll();
			if (res != null) {
				return PolicyResponse.isSuccess(200, "SuccessFully Fetch!", true, res);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return PolicyResponse.isFailed(500, "Failed !", false);
	}

	@Override
	public PolicyResponse getPolicyById(int id) {
		try {
			InsurancePolicy res = repo.findPolicyById(id);
			if (res != null) {

				List<InsurancePolicy> resp = new ArrayList<>();
				resp.add(res);
				return PolicyResponse.isSuccess(200, "SuccessFully Fetch!", true, resp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return PolicyResponse.isFailed(500, "Id does not Exist or must be deleted!", false);
	}

	@Override
	public BaseResponse createPolicy(InsurancePolicyDTO policy) {
		try {
			InsurancePolicy res = new InsurancePolicy();
			res.setPremium(policy.getPremium());
			res.setCoverageAmt(policy.getCoverageAmt());
			res.setType(policy.getType());
			res.setStartDate(policy.getStartDate());
			res.setEndDate(policy.getEndDate());

			if (repo.save(res) != null) {
				return BaseResponse.isSuccessOrFailed(200, "Data Saved SuccessFully!", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return BaseResponse.isSuccessOrFailed(500, "Failed!", false);
	}

	@Override
	public BaseResponse updatePolicy(int id, InsurancePolicyDTO policy) {
		try {
			InsurancePolicy res = repo.findPolicyById(id);
			if (res != null) {

				res.setStartDate(policy.getStartDate());
				res.setType(policy.getType());
				res.setEndDate(policy.getEndDate());
				res.setCoverageAmt(policy.getCoverageAmt());
				res.setPremium(policy.getPremium());

				repo.save(res);

				return BaseResponse.isSuccessOrFailed(200, "Data updated!", true);
			} else if (res == null) {

				return createPolicy(policy);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return BaseResponse.isSuccessOrFailed(500, "Failed To Update!", false);
	}

	@Override
	public BaseResponse deletePolicy(int id) {
		try {
			InsurancePolicy policy = repo.findPolicyById(id);

			if (id == 0 || policy == null) {
				return BaseResponse.isSuccessOrFailed(500, "Id must be null or does not exists ", false);
			} else {
				repo.deleteById(id);
				return BaseResponse.isSuccessOrFailed(200, "Successfully deleted !", true);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
