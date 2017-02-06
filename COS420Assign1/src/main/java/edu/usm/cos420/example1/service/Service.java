package edu.usm.cos420.example1.service;

import java.util.List;

import edu.usm.cos420.example1.domain.CItem;

/**
 *  The Service Interface is based a design pattern
 *      which aims to organize the functionality of the application into logical units 
 *      that are typically layered on top of much of the low level functionality of the 
 *      application. This organization helps support service oriented architectures. 
 */
public interface Service 
{
	/**
	 * Add a CItem element to the repository
	 * @param ci the element to be added; will be downcast to the proper type
	 */
    public void add(CItem ci);
    
    /**
     * Update a CItem in the repository
     * @param ci the CItem to be updated
     */
    public void update(CItem ci);
    
    /**
     * Find a CItem in the repository
     * @param key the id for the CItem
     * @return the CItem with the id key
     */
    public CItem find(String key);
    
    /**
     * Return the list of elements for the service
     * @return the list of elements
     */
    public List<? extends CItem> getList();
    
    /**
     * @return the string representation of the CItem
     */
    public String toString(); 
}
