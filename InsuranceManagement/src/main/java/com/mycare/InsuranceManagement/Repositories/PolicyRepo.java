package com.mycare.InsuranceManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycare.InsuranceManagement.Model.InsurancePolicy;

@Repository
public interface PolicyRepo  extends JpaRepository<InsurancePolicy, Integer> {

	
	@Query(value = "select * from insurance_policy a where a.policy_no = :id",nativeQuery=true)
	InsurancePolicy findPolicyById(int id);
	
	@Query(value = "select EXISTS(select * from insurance_policy a where a.policy_no = :id)",nativeQuery=true)
	public int isExistOrNot(@Param("id") int id) ;

}
