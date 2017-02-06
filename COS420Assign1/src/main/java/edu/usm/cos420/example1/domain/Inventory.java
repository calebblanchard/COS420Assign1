package edu.usm.cos420.example1.domain;

public class Inventory extends CItem
{
	private final String description;
	private Integer stock;
	
	/**
	 * Constructor for an inventory item
	 * 
	 * @param id the item's id
	 * @param description the item's description
	 * @param initialStock the amount of stock for the item
	 */
	public Inventory(String id, String description, Integer initialStock)
	{
		super(id);
		
		this.description = description;
		this.stock = initialStock;
	}
	
	/**
	 * Gets the item id
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Gets the item description
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Gets the item's stock
	 * @return the stock
	 */
	public int getStock()
	{
		return stock;
	}
	
	/**
	 * Sets the item's stock
	 * @return the stock
	 */
	public void setStock(Integer stock)
	{
		this.stock = stock;
	}
	
	/**
	 * Adds stock to an item in the inventory
	 * @param otherStock the amount of stock to be added
	 */
	public void addStock(Integer otherStock)
	{
		stock += otherStock;
	}
	
	/**
	 * Removes stock from an item in the inventory
	 * @param otherStock the amount of stock to be removed
	 */
	public void removeStock(Integer otherStock)
	{
		stock -= otherStock;
	}
	
	/**
	 * @return The string representation of an Inventory item
	 */
	public String toString()
	{
		return "\n" + id + "\t\t" + description + "       " + stock + "\n";
	}
}