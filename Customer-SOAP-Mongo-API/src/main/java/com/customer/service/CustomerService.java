package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.model.CustomerBean;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerBean getCustomer(int i) {
		CustomerBean cus = customerRepository.getByCustomerId(i);
		return cus;	
	}

	public List<CustomerBean> getAllCustomer() {
		List<CustomerBean> cusList = new ArrayList<>();
		customerRepository.findAll().forEach(e -> cusList.add(e));;
		return cusList;	
	}

}
