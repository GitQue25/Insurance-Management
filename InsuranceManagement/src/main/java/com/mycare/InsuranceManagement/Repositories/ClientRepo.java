package com.mycare.InsuranceManagement.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycare.InsuranceManagement.Model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
	
	
	@Query(value = "select * from client a where a.client_id = :id",nativeQuery=true)
	public Client findClientById(@Param("id") int id);
	

	@Query(value = "select EXISTS(select * from client a where a.client_id = :id)",nativeQuery=true)
	public int isClientIdExistOrNot(@Param("id") int id) ;
}
