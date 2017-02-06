package edu.usm.cos420.example1.service.impl;

import java.util.List;

import edu.usm.cos420.example1.dao.domain.CustomerDao;
import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.Customer;
import edu.usm.cos420.example1.service.Service;

/**
 *  The Customer Service class implements the Service interface
 *  	This is used for services related to customers
 */
public class CustomerService implements Service
{
	CustomerDao dao;

	/**
	 * Default Constructor creates a default CustomerDao object 
	 */
	public CustomerService()
	{
		this.dao = new CustomerDao();	
	}

	/**
	 * Constructor with the DAO provided 
	 * @param dao Data Access Object to use in the service
	 */
	public CustomerService(CustomerDao dao)
	{
		this.dao = dao;	
	}

	/**
	 * Add a Customer element to the Customer repository
	 * @param ci the Customer to be added
	 */
	public void add(CItem ci) 
	{
		// Need to downcast to type Customer
		Customer newCustomer = (Customer) ci; 
		dao.add(newCustomer);
	}
	
	// TODO: I'm casting to Customer in the Controller as well...
	/**
	 * Find a Customer element in the Customer repository
	 * @param key the key to find the Customer
	 */
	public CItem find(String key)
	{
		return (Customer) dao.find(key);
	}
	
	/**
	 * Updates a Customer element in the Customer repository
	 * @param ci the Customer to be updated
	 */
	public void update(CItem ci) 
	{
		dao.update((Customer) ci);
	}

	/**
	 * Return the list of Customers in the repository
	 * @return the list of Customers
	 */
	public List<Customer> getList() 
	{
		return dao.list();
	}

	/**
	 * @return the string representation of the Customer repository contents
	 */
	public String toString() 
	{
		return dao.list().toString();
	}
}
