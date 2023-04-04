package com.mycare.InsuranceManagement.Services;

import java.util.List;

import com.mycare.InsuranceManagement.DTO.ClientDTO;
import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClientResponse;

public interface ClientServices {

	ClientResponse getAllClientDetails();

	ClientResponse getClientById(int id);

	BaseResponse createClient(ClientDTO client);

	BaseResponse updateClient(int id, ClientDTO client);

	BaseResponse deleteClient(int id);

}
