package com.mycare.InsuranceManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycare.InsuranceManagement.Model.Claim;
import com.mycare.InsuranceManagement.Model.Client;

@Repository
public interface ClaimRepo  extends JpaRepository<Claim, Integer>{
	
	@Query(value = "select * from claim a where a.claim_no = :id",nativeQuery=true)
	public Claim findClaimById(@Param("id") int id);
	
	@Query(value = "select EXISTS(select * from claim a where a.claim_no = :id)",nativeQuery=true)
	public int isClaimNoExistOrNot(@Param("id") int id) ;
}
