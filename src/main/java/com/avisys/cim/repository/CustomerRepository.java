package com.avisys.cim.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avisys.cim.entity.Customer;

import jakarta.persistence.TypedQuery;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	 @Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')) " +
	            "AND LOWER(c.lastName) LIKE LOWER(CONCAT('%', :lastName, '%')) " +
	            "AND c.mobileNumber = :mobileNumber")
	    List<Customer> searchCustomers(@Param("firstName") String firstName,
	                                   @Param("lastName") String lastName,
	                                   @Param("mobileNumber") String mobileNumber);
	 
	 Customer findByMobileNumber(String mobileNumber);
    
    
}



