package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.CustomerDetails;
import com.capgemini.exception.CustomerDetailsNotFoundException;
import com.capgemini.repository.CustomerDetailsRepository;

@Service
public class CustomerServiceImpl implements ICustomerDetails {
	
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;

	@Override
	public String addCustomerDetails(CustomerDetails customerdetails) {
		customerDetailsRepository.save(customerdetails);
		return "Customer Details Created";
	}

	@Override
	public String updateCustomerDetails(int id, CustomerDetails customerDetails)  {
		if(!customerDetailsRepository.existsById(id)) {
			throw new CustomerDetailsNotFoundException("Check the id and Try again");
		}
		
		CustomerDetails ld=customerDetailsRepository.findById(id).get();
		ld.setId(customerDetails.getId());
		customerDetailsRepository.save(ld);
		
		return "Customer Details Added!";
		
	}

	@Override
	public String deleteCustomerDetails(int id) {
		customerDetailsRepository.deleteById(id);
		return "Record deleted";
	}

}
