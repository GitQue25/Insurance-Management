package com.mycare.InsuranceManagement.Controller;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycare.InsuranceManagement.DTO.ClaimDTO;
import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClaimResponse;
import com.mycare.InsuranceManagement.Services.ClaimServices;


@RestController
@RequestMapping("api/claims")
public class ClaimController {

	@Autowired
	ClaimServices ser;

	@GetMapping("/get-all-claims")
	public ClaimResponse getAllClaims() {
		return ser.getClaimDetails();

	}

	@GetMapping("/get-claim-by-id/{id}")
	public ClaimResponse getClaimById(@PathVariable("id") int id) {
		return ser.getClaimById(id);

	}

	@PostMapping("/create-claim")
	public BaseResponse createNewClaim(@RequestBody ClaimDTO claim) {
		return ser.createClaim(claim);

	}

	@PutMapping("/update-claim/{id}")
	public BaseResponse updateClaimById(@PathVariable("id") int id,@RequestBody ClaimDTO claim) {
		return ser.updateClaim(id,claim);

	}

	@DeleteMapping("/delete-claim/{id}")
	public BaseResponse deleteClaimById(@PathVariable("id") int id) {
		return ser.deleteClaim(id);

	}

}
