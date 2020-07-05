package com.customer.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.CustomerBean;


@Repository
public interface CustomerRepository extends MongoRepository<CustomerBean, Integer> 
{
	public CustomerBean getByCustomerId(int customerId);
}