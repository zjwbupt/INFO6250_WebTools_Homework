package com.zjw.springdemo.dao;

import com.zjw.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", 
						Customer.class);
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get curreent hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer to the database
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomers(int theId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//now retrieve from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}


}
