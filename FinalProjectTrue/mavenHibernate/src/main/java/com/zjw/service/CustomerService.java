package com.zjw.service;

import com.zjw.entity.*;
import java.util.*;

public interface CustomerService {

	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

	List<Customer> searchCustomers(String theSearchName);
}
