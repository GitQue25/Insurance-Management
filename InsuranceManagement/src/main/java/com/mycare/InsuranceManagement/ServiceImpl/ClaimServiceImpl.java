package com.mycare.InsuranceManagement.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycare.InsuranceManagement.DTO.ClaimDTO;
import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Repositories.ClaimRepo;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClaimResponse;
import com.mycare.InsuranceManagement.Services.ClaimServices;

@Service
public class ClaimServiceImpl implements ClaimServices {

	@Autowired
	ClaimRepo repo;
	

	@Override
	public ClaimResponse getClaimDetails() {
		try {
			List<Claim> res = repo.findAll();
			if (res != null) {
				return ClaimResponse.isSuccess(200, "SuccessFully Fetch!", true, res);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ClaimResponse.isFailed(500, "Failed !", false);
	}

	@Override
	public ClaimResponse getClaimById(int id) {
		try {
			Claim res = repo.findClaimById(id);
			if (res != null) {

				List<Claim> resp = new ArrayList<>();
				resp.add(res);
				return ClaimResponse.isSuccess(200, "SuccessFully Fetch!", true, resp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ClaimResponse.isFailed(500, "Id does not Exist or must be deleted!", false);
	}

	@Override
	public BaseResponse createClaim(ClaimDTO claim) {
		try {
			Claim res=new Claim();
			res.setClaimDate(claim.getClaimDate());
			res.setClaimStatus(claim.getClaimStatus());
			res.setClaimDiscription(claim.getClaimDiscription());
		
			if ( repo.save(res)!= null) {
				return BaseResponse.isSuccessOrFailed(200, "Data Saved SuccessFully!", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return BaseResponse.isSuccessOrFailed(500, "Failed!", false);
	}

	@Override
	public BaseResponse updateClaim(int id, ClaimDTO claim) {
		try {
			Claim res = repo.findClaimById(id);
			if (res != null) {
				res.setClaimStatus(claim.getClaimStatus());
				res.setClaimDiscription(claim.getClaimDiscription());
				res.setClaimDate(claim.getClaimDate());
				repo.save(res);
				return BaseResponse.isSuccessOrFailed(200, "Data updated!", true);
			} else if(res == null) {
			
				return createClaim(claim);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return BaseResponse.isSuccessOrFailed(500, "Failed To Update!", false);
	}

	@Override
	public BaseResponse deleteClaim(int id) {
		try {

			Claim res=repo.findClaimById(id);
			if(id == 0 || res ==null) {
				return BaseResponse.isSuccessOrFailed(500, "Id must be null or does not exists", false);
			}else {
			repo.deleteById(id);
			return BaseResponse.isSuccessOrFailed(200, "Successfully deleted !", true);
			
			}} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
