package com.zjw.controller;

import com.zjw.entity.Customer;
import com.zjw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {


    //need to inject our customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        System.out.print("entering controller");
        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        System.out.println("Jumping...");
        return "list-customers";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        //create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        //save the customer
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        //get the customer from the database
        Customer theCustomer = customerService.getCustomer(theId);

        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);


        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        //delete the customer from the database
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel){

        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
