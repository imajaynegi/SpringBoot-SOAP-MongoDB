package com.customer.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "customer")
public class CustomerBean {


	@Id
	private int customerId;
	private String customerName;
	private long accountId;
	private String customerAddress;




	public CustomerBean(int customerId, String customerName, long accountId, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.accountId = accountId;
		this.customerAddress = customerAddress;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", accountId=" + accountId
				+ ", customerAddress=" + customerAddress + "]";
	}




}
