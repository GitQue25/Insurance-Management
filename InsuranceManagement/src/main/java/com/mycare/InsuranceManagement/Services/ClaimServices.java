package com.mycare.InsuranceManagement.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycare.InsuranceManagement.DTO.ClaimDTO;
import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClaimResponse;


public interface ClaimServices {

	ClaimResponse getClaimDetails();

	ClaimResponse getClaimById(int id);

	BaseResponse createClaim(ClaimDTO claim);


	BaseResponse deleteClaim(int id);

	BaseResponse updateClaim(int id, ClaimDTO claim);

}
