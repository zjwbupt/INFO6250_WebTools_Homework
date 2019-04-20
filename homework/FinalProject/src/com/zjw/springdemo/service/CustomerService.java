package com.zjw.springdemo.service;

import com.zjw.springdemo.entity.*;
import java.util.*;

public interface CustomerService {

	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
}
