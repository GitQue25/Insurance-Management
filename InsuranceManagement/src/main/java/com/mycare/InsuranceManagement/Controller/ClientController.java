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

import com.mycare.InsuranceManagement.DTO.ClientDTO;
import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Response.BaseResponse;
import com.mycare.InsuranceManagement.Response.ClientResponse;
import com.mycare.InsuranceManagement.Services.ClientServices;

@RestController
@RequestMapping("api/clients")
public class ClientController {

	@Autowired
	ClientServices ser;

	@GetMapping("/get-all-clients")
	public ClientResponse getAllClient() {
		return ser.getAllClientDetails();

	}

	@GetMapping("/get-client-by-id/{id}")
	public ClientResponse getClientById(@PathVariable("id") int id) {
		return ser.getClientById(id);

	}

	@PostMapping(value ="/create-client")
	public BaseResponse createNewClient(@RequestBody ClientDTO client) {
		return ser.createClient(client);

	}

	@PutMapping("/update-client-details/{id}")
	public BaseResponse updateClientById(@PathVariable("id") int id,@RequestBody ClientDTO client ) {
		return ser.updateClient(id,client);

	}

	@DeleteMapping("/delete-client/{id}")
	public BaseResponse deleteClientById(@PathVariable("id") int id) {
		return ser.deleteClient(id);

	}

}
