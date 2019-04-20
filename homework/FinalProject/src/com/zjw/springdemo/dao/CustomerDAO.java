package com.zjw.springdemo.dao;

import java.util.List;

import com.zjw.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
}
