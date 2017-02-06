package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.Inventory;

/**
 *  A Data Access Object specifically for Customer entities 
 */
public class InventoryDao
{
	// TODO: refactor this class later, currently "duplicates" CItemDao
	private GenericDao<String, Inventory> inventoryDao;

	/**
	 * Default constructor creates an ObjectStream file called inventory.ser
	 */
	public InventoryDao()
	{
		inventoryDao = new ObjectStreamDao<String, Inventory>("inventory.ser");
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public InventoryDao(String fileName)
	{
		inventoryDao = new ObjectStreamDao<String, Inventory>(fileName);
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long, Inventory> 
	 */
	public InventoryDao(GenericDao<String, Inventory> dao)
	{
		inventoryDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long, Inventory> 
	 */
	public GenericDao<String, Inventory> getCItemDao() 
	{
		return inventoryDao;
	}

	/**
	 * Add a Inventory to the DAO repository
	 * @param entity any Inventory object
	 */
	public void add(Inventory entity)
	{
		inventoryDao.add(entity.getId(), entity);
	}

	/**
	 * Update a Inventory in the DAO repository
	 * @param entity any Inventory object
	 */
	public void update(Inventory entity) 
	{
		inventoryDao.update(entity.getId(), entity);
	}

	/**
	 * Remove a Inventory in the DAO repository
	 * @param id of the Inventory object to remove
	 */
	public void remove(String id)
	{
		inventoryDao.remove(id);
	}

	/**
	 * Find a Inventory in the DAO repository
	 * @param id of the Inventory object to locate
	 * @return the Inventory with id field equal to key
	 */
	public CItem find(String key)
	{
		return inventoryDao.find(key);
	}

	/**
	 * Generate a list of Inventory in the DAO repository
	 * @return List of Inventory
	 */
	public List<Inventory> list() 
	{
		return inventoryDao.list();
	}
}
