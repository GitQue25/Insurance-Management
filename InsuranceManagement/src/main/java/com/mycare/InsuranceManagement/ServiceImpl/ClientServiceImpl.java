package com.mycare.InsuranceManagement.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycare.InsuranceManagement.DTO.ClientDTO;
import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Repositories.ClientRepo;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClientResponse;
import com.mycare.InsuranceManagement.Services.ClientServices;

@Service
public class ClientServiceImpl implements ClientServices {

	@Autowired
	ClientRepo repo;

	@Override
	public ClientResponse getAllClientDetails() {
		try {
			List<Client> res = repo.findAll();
			if (res != null) {
				return ClientResponse.isSuccess(200, "SuccessFully Fetch!", true, res);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ClientResponse.isFailed(500, "Failed !", false);
	}

	@Override
	public ClientResponse getClientById(int id) {
		try {
			List<Client> response=new ArrayList<>();
			Client res = repo.findClientById(id);
			if (res != null) {
				response.add(res);
				
				return ClientResponse.isSuccess(200, "SuccessFully Fetch!", true, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ClientResponse.isFailed(500, "Id does not Exist or must be deleted!", false);
	}

	@Override
	public BaseResponse createClient(ClientDTO client) {
		try {
			Client res = new Client();
			res.setName(client.getName());
			res.setContactInfo(client.getContactInfo());
			res.setDateOfBirth(client.getDateOfBirth());

			res.setAddress(client.getAddress());

			if (repo.save(res) != null) {
				return BaseResponse.isSuccessOrFailed(200, "Data Saved SuccessFully!", true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return BaseResponse.isSuccessOrFailed(500, "Failed!", false);

	}

	@Override
	public BaseResponse updateClient(int id, ClientDTO client) {
		try {
			Client res = repo.findClientById(id);
			if (res != null) {
				res.setName(client.getName());
				res.setDateOfBirth(client.getDateOfBirth());
				res.setContactInfo(client.getContactInfo());
				res.setAddress(client.getAddress());
				repo.save(res);
				return BaseResponse.isSuccessOrFailed(200, "Data updated!", true);
			} else if(res == null) {
				
				return createClient(client);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return BaseResponse.isSuccessOrFailed(500, "Failed To Update!", false);

	}

	@Override
	public BaseResponse deleteClient(int id) {
		try {
			
			Client e=repo.findClientById(id);
			if (id == 0 || e ==null) {
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
