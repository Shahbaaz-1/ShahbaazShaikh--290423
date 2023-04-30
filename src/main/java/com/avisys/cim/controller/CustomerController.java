package com.avisys.cim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.entity.Customer;
import com.avisys.cim.service.CustomerService;



@RestController
public class CustomerController {

	    @Autowired
	    CustomerService customerService;

	    @GetMapping("/getCustomers")
	    public  List<Customer> getAllCustomers() {
	    	
	       
				return customerService.getAllCustomers();
			
	
	    }
	    
	    @GetMapping("/customers")
	    public List<Customer> searchCustomers(@RequestParam(required = false) String firstName,
	                                          @RequestParam(required = false) String lastName,
	                                          @RequestParam(required = false) String mobileNumber) {
	        return customerService.searchCustomers(firstName, lastName, mobileNumber);
	    }
	    
	    @PostMapping("/create")
	    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
	        try {
	            Customer createdCustomer = customerService.createCustomer(customer);
	            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	        } catch (Exception ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    

}



