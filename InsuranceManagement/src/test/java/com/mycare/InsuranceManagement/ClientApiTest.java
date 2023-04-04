package com.mycare.InsuranceManagement;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Repositories.ClientRepo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientApiTest {

	@Autowired
	ClientRepo repo;

	@Test
	@Order(1)
	public void saveClientTest() {

		Client client = new Client("Rupa", "12/01/2012", "Delhi", "8767564565");
		repo.save(client);
		Assertions.assertThat(client.getClientId()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	void getClientByIdTest() {

		Client c = repo.findById(2).get();
		Assertions.assertThat(c.getClientId()).isEqualTo(2);
	}

	@Test
	@Order(3)
	void getAllClientListTest() {
		List<Client> p = repo.findAll();
		Assertions.assertThat(p.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	void updateClientTest() {
		Client cl = repo.findById(2).get();
		cl.setDateOfBirth("05/05/2000");
		cl.setAddress("N/A");
		cl.setContactInfo("5678988798");
		cl.setName("Deepa");
		Client clientUpdated = repo.save(cl);
		Assertions.assertThat(clientUpdated.getClientId()).isEqualTo(2);
	}

	@Test
	@Order(5)
	void deleteClientTest() {
		Client cli = repo.findById(3).get();
		repo.delete(cli);

		int res = repo.isClientIdExistOrNot(3);
		System.err.println(res);
		Assertions.assertThat(res).isEqualTo(0);

	}

}
