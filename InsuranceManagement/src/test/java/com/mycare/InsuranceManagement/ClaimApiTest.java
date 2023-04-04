package com.mycare.InsuranceManagement;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Model.Client;
import com.mycare.InsuranceManagement.Repositories.ClaimRepo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClaimApiTest {

	@Autowired
	ClaimRepo repo;

	@Test
	@Order(1)
	public void saveClientTest() {

		Claim claim = new Claim("12/01/2012", "Open", "claim z");
		repo.save(claim);
		Assertions.assertThat(claim.getClaimNo()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	void getClientByIdTest() {

		Claim c = repo.findById(3).get();
		Assertions.assertThat(c.getClaimNo()).isEqualTo(3);
	}

	@Test
	@Order(3)
	void getAllClientListTest() {
		List<Claim> p = repo.findAll();
		Assertions.assertThat(p.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	void updateClientTest() {
		Claim cl = repo.findById(4).get();
		cl.setClaimStatus("Closed");
		cl.setClaimDiscription("Claim4");
		cl.setClaimDate("04/04/2023");
		Claim clientUpdated = repo.save(cl);
		Assertions.assertThat(clientUpdated.getClaimNo()).isEqualTo(4);
	}

	@Test
	@Order(5)
	void deleteClientTest() {
		Claim cli = repo.findById(6).get();
		repo.delete(cli);
        int  res = repo.isClaimNoExistOrNot(6);

		Assertions.assertThat(res).isEqualTo(0);

	}

}
