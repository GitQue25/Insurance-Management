package com.mycare.InsuranceManagement;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mycare.InsuranceManagement.Model.InsurancePolicy;
import com.mycare.InsuranceManagement.Repositories.PolicyRepo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PolicyApiTest {

	@Autowired
	PolicyRepo repo;

	@Test
	@Order(1)
	public void saveClientTest() {

		InsurancePolicy policy = new InsurancePolicy("House", "50000", "High", "07/09/2020", "02/04/2022");
		repo.save(policy);
		Assertions.assertThat(policy.getPolicyNo()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	void getClientByIdTest() {

		InsurancePolicy c = repo.findById(3).get();
		Assertions.assertThat(c.getPolicyNo()).isEqualTo(3);
	}

	@Test
	@Order(3)
	void getAllClientListTest() {
		List<InsurancePolicy> p = repo.findAll();
		Assertions.assertThat(p.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	void updateClientTest() {
		InsurancePolicy cl = repo.findById(2).get();
		cl.setType("Electronic Device");
		cl.setCoverageAmt("45000");
		cl.setEndDate("23/12/2012");
		cl.setStartDate("21/08/2000");
		cl.setPremium("Standard");
		InsurancePolicy policyUpdated = repo.save(cl);
		Assertions.assertThat(policyUpdated.getPolicyNo()).isEqualTo(2);
	}

	@Test
	@Order(5)
	void deleteClientTest() {
		InsurancePolicy cli = repo.findById(21).get();
		repo.delete(cli);
		int res = repo.isExistOrNot(21);

		Assertions.assertThat(res).isEqualTo(0);

	}

}
