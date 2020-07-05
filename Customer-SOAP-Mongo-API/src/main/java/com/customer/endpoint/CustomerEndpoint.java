package com.customer.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.customer.cus_ws.Customer;
import com.customer.cus_ws.CustomerRequest;
import com.customer.cus_ws.CustomerResponse;
import com.customer.cus_ws.GetAllCustomerResponse;
import com.customer.model.CustomerBean;
import com.customer.service.CustomerService;


@Endpoint
public class CustomerEndpoint {

	private static final String NAMESPACE = "http://www.customer.com/spring/soap/api/getcustomer";

	@Autowired
	private CustomerService cutomerService;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public CustomerResponse getCustomerDetails(@RequestPayload CustomerRequest request) {
		CustomerResponse response= new CustomerResponse();
		Customer customer=new Customer();
		BeanUtils.copyProperties(cutomerService.getCustomer(request.getCustomerId()), customer);
		response.setCustomer(customer);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "getAllCustomerRequest")
	@ResponsePayload
	public GetAllCustomerResponse getAllArticles() {
		GetAllCustomerResponse response = new GetAllCustomerResponse();
		List<Customer> customerList = new ArrayList<>();
		List<CustomerBean> customerBeanList = cutomerService.getAllCustomer();
		for (int i = 0; i < customerBeanList.size(); i++) {
			Customer cust = new Customer();
			BeanUtils.copyProperties(customerBeanList.get(i), cust);
			customerList.add(cust);    
		}
		response.getCustomerInfo().addAll(customerList);
		return response;
	}	



}
