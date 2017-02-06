package edu.usm.cos420.example1.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends CItem
{
	private final String name; // the name
	private final String address; // the address
	private List<InventoryList> ordersList; // the orders associated with the customer
	
	/**
	 * Constructor for the Customer class
	 * @param the customer's id
	 * @param the customer's name
	 * @param the customer's address
	 */
	public Customer(String id, String name, String address)
	{
		super(id);
		
		this.name = name;
		this.address = address;
		this.ordersList = new ArrayList<InventoryList>();
	}
	
	/**
	 * Gets the customer's name
	 * @return the customer's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the customer's address
	 * @return the customer's address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Gets the list orders made by the customer
	 * @return the list of orders made by the customer
	 */
	public List<InventoryList> getOrdersList()
	{
		return ordersList;
	}
	
	/**
	 * Adds an order to the customer's list of orders
	 * @param newOrder the order to be added to the orders list
	 */
	public void addOrder(InventoryList newOrder)
	{
		ordersList.add(newOrder);
	}
	
	/**
	 * @return The string representation of an Inventory item
	 */
	public String toString()
	{
		return "\n" + id + "\t\t" + name + "\t\t" + address + "\n";
	}
}
