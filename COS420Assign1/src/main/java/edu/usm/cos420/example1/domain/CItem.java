/*
 * CItem.java
 *
 * Created on August 28, 2001, 11:46 AM
 */

package edu.usm.cos420.example1.domain;

import java.io.Serializable;

/**
 *  The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 */
public class CItem implements Serializable 
{
	protected static final long serialVersionUID = 7526472295622776147L; // TODO: What is this for???
	protected String id; // the id for any entity extending from this class
	protected String strRep; // will hold the string rep of entities

	/** 
	 * Default Constructor : 
	 * Creates new CItem with an id
	 * @param id the id
	 */
	public CItem(String id) 
	{
		this.id = id;
	}

	/**
	 * get the id of the CItem 
	 * @return the id 
	 */
	public String getId() 
	{
		return id;
	}
	
	//
	//	/**
	//	 * Returns the String representation of this User. Not required, it just pleases reading logs.
	//	 * @see java.lang.Object#toString()
	//	 */
	//	@Override
	//	public String toString() 
	//	{
	//		this.strRep = String.format("CItem id=%d", getId());
	//		return strRep; // generic string rep, will likely never be returned
	//	}

	// for autogeneration of ids
	// private Long generateId()
	// {
	// 		return COUNTER++;
	// }
}
