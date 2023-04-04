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

import com.mycare.InsuranceManagement.DTO.InsurancePolicyDTO;
import com.mycare.InsuranceManagement.Model.InsurancePolicy;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.PolicyResponse;
import com.mycare.InsuranceManagement.Services.PolicyServices;



@RestController
@RequestMapping("api/policies")
public class PolicyController {
	@Autowired
	PolicyServices ser;
		
	@GetMapping("/get-all-policies")
	public PolicyResponse getAllPolicies(){
		return ser.getAllPolicies();
		
	}
	
	@GetMapping("/get-policy-by-id/{id}")
	public PolicyResponse getPolicyById(@PathVariable("id") int id){
		return ser.getPolicyById(id);
		
	}
	
	
	@PostMapping("/create-policy")
	public BaseResponse createNewPolicy(@RequestBody InsurancePolicyDTO policy) {
		return ser.createPolicy(policy);
		
	}
	
	@PutMapping("/update-policy/{id}")
	public BaseResponse updatePolicyById(@PathVariable("id") int id,@RequestBody InsurancePolicyDTO policy) {
		return ser.updatePolicy(id,policy);	
	}
	
	
	
	@DeleteMapping("/delete-policy/{id}")
	public BaseResponse deletePolicyById(@PathVariable("id") int id) {
		return ser.deletePolicy(id);
		
	}
	
	
}
