package com.zjw.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjw.springdemo.dao.CustomerDAO;
import com.zjw.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customer from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		
		//add the customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		System.out.println("start to switch to listcustomers");
		return "list-customers";
	
	}
}
