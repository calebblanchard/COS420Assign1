package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.Customer;

/**
 *  A Data Access Object specifically for Customer entities 
 */
public class CustomerDao
{
	// TODO: refactor this class later, currently "duplicates" CItemDao
	private GenericDao<String, Customer> customerDao;

	/**
	 * Default constructor creates an ObjectStream file called customers.ser
	 */
	public CustomerDao()
	{
		customerDao = new ObjectStreamDao<String, Customer>("customers.ser");
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public CustomerDao(String fileName)
	{
		customerDao = new ObjectStreamDao<String, Customer>(fileName);
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long, Customer> 
	 */
	public CustomerDao(GenericDao<String, Customer> dao)
	{
		customerDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long, Customer> 
	 */
	public GenericDao<String, Customer> getCItemDao() 
	{
		return customerDao;
	}

	/**
	 * Add a Customer to the DAO repository
	 * @param entity any Customer object
	 */
	public void add(Customer entity)
	{
		customerDao.add(entity.getId(), entity);
	}

	/**
	 * Update a Customer in the DAO repository
	 * @param entity any Customer object
	 */
	public void update(Customer entity) 
	{
		customerDao.update(entity.getId(), entity);
	}

	/**
	 * Remove a Customer in the DAO repository
	 * @param id of the Customer object to remove
	 */
	public void remove(String id)
	{
		customerDao.remove(id);
	}

	/**
	 * Find a Customer in the DAO repository
	 * @param id of the Customer object to locate
	 * @return the Customer with id field equal to key
	 */
	public CItem find(String key)
	{
		return customerDao.find(key);
	}

	/**
	 * Generate a list of Customer in the DAO repository
	 * @return List of Customer
	 */
	public List<Customer> list() 
	{
		return customerDao.list();
	}
}
