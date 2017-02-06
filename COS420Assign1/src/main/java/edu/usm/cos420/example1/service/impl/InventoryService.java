package edu.usm.cos420.example1.service.impl;

import java.util.List;

import edu.usm.cos420.example1.dao.domain.InventoryDao;
import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.Inventory;
import edu.usm.cos420.example1.service.Service;

/**
 *  The Inventory Service class implements the Service interface
 *  	This is used for services related to inventory
 */
public class InventoryService implements Service
{
	InventoryDao dao;

	/**
	 * Default Constructor creates a default InventoryDao object 
	 */
	public InventoryService()
	{
		this.dao = new InventoryDao();	
	}

	/**
	 * Constructor with the DAO provided 
	 * @param dao Data Access Object to use in the service
	 */
	public InventoryService(InventoryDao dao)
	{
		this.dao = dao;	
	}

	/**
	 * Add a Inventory element to the Inventory repository
	 * @param ci the Inventory to be added
	 */
	public void add(CItem ci) 
	{
		Inventory newInventory = (Inventory) ci;
		dao.add(newInventory);
	}

	/**
	 * Find an Inventory element in the Inventory repository
	 * @param key the key to find the Inventory
	 */
	public CItem find(String key)
	{
		return (Inventory) dao.find(key);
	}

	/**
	 * Updates a Inventory element in the Inventory repository
	 * @param ci the Inventory to be updated
	 */
	public void update(CItem ci) 
	{
		dao.update((Inventory) ci);
	}

	/**
	 * Return the list of Inventory in the repository
	 * @return the list of Inventory
	 */
	public List<Inventory> getList() 
	{
		return dao.list();
	}

	/**
	 * @return the string representation of the Inventory repository contents
	 */
	public String toString() 
	{
		return dao.list().toString();
	}
}
