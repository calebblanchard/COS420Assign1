package edu.usm.cos420.example1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InventoryList implements Serializable
{
	
	private static final long serialVersionUID = -8770596156937430487L;
	private List<Inventory> theList; // the list within the list
	private Calendar orderDate; // the date an order was placed
	
	/**
	 * Default Constructor used for the store's inventory list; 
	 * no date needed
	 */
	public InventoryList()
	{
		this.theList = new ArrayList<Inventory>();
	}
	
	/**
	 * Other default constructor for wrapping the service list 
	 * @param theList
	 */
	public InventoryList(List<Inventory> theList)
	{
		this.theList = (ArrayList<Inventory>) theList;
	}
	
	/**
	 * Constructor for building the orderList of items for a Customer
	 * @param orderDate the date the order was placed
	 */
	public InventoryList(Calendar orderDate)
	{
		this.theList = new ArrayList<Inventory>();
		this.orderDate = orderDate;
	}
	
	/**
	 * Adds an item to the order list
	 * @param newInventory the item to be added
	 */
	public void add(Inventory newInventory) 
	{
		theList.add(newInventory);
	}
	
	/**
	 * Sets the list
	 * @param theList the list to be set
	 */
	public void setList(ArrayList<Inventory> theList)
	{
		this.theList = theList;
	}
	
	/**
	 * Gets the list
	 * @return the list
	 */
	public List<Inventory> getList()
	{
		return theList;
	}
	
	/**
	 * Gets the order date
	 * @return the order date
	 */
	public Calendar getOrderDate()
	{
		return orderDate;
	}
	
	/**
	 * @return the string representation of an order list
	 */
	public String toString()
	{
		String order = "";
		if(orderDate != null)
			order += "Order placed on: " + (orderDate.get(Calendar.MONTH) + 1) + "/" + orderDate.get(Calendar.DAY_OF_MONTH) + "/" + orderDate.get(Calendar.YEAR) + "\n";
		
		order += "ID#" + "\t\t" + "Description" + "       " + "Stock" + "\n";
		order += theList.toString();
		
		return order;
	}
}