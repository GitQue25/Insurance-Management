package com.mycare.InsuranceManagement.Services;

import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Response.BaseResponse;

public interface ClientPolicyMapping {

	BaseResponse addMapping(Client client);

}
