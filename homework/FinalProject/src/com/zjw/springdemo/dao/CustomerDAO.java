package com.zjw.springdemo.dao;

import com.zjw.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	void deleteCustomer(int theId);
}
