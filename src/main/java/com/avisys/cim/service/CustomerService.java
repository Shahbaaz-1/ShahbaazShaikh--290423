package com.avisys.cim.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.entity.Customer;
import com.avisys.cim.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private   CustomerRepository customerRepository;

    public  List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

  
    public List<Customer> searchCustomers(String firstName, String lastName, String mobileNumber) {
        return customerRepository.searchCustomers(firstName, lastName, mobileNumber);
    }
    
    public Customer createCustomer(Customer customer) throws Exception {
        if (customerRepository.findByMobileNumber(customer.getMobileNumber()) != null) {
            throw new Exception("Unable to create Customer. Mobile number already present.");
        }
        return customerRepository.save(customer);
    }

}
