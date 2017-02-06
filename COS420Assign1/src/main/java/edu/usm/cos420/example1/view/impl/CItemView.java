package edu.usm.cos420.example1.view.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 
 * CItemView class 
 *    A Command line User Interface which displays menu 
 *    of CItem options to user and collects the user choice.  
 */

public class CItemView
{
	/** {@value} : no choice selected by user */
	public static final int NO_CHOICE = 0;

	/** {@value #ADDCUSTOMER} : Add one Customer to the collection of Customer */
	public static final int ADDCUSTOMER = 1;

	/** {@value #DISPLAYCUSTOMERS} : display the list of Customers */
	public static final int DISPLAYCUSTOMERS = 2;

	/** {@value #ADDINVENTORY} : Add one Inventory item to the list of Inventory */
	public static final int ADDINVENTORY = 3;

	/** {@value #ADDSTOCK} : add stock to an Inventory item */
	public static final int ADDSTOCK = 4;

	/** {@value #DISPLAYINVENTORY} : display the list of Inventory */
	public static final int DISPLAYINVENTORY = 5;

	/** {@value #PLACEORDER} : Add an order to the list of orders for a Customer */
	public static final int PLACEORDER = 6;

	/** {@value #DISPLAYORDERS} : display the list of orders for a Customer */
	public static final int DISPLAYORDERS = 7;

	/** {@value #EXIT} : Exit the program */
	public static final int EXIT = 8;

	// Object to read menu choices
	private static Scanner input = new Scanner(System.in); 

	/**
	 * Constructor. Doesn't take any parameters
	 */
	public CItemView() {}

	/**
	 * Displays the top level menu.
	 */
	public void displayMenu() 
	{
		System.out.println();
		System.out.println("Enter the number denoting the action to perform: ");
		System.out.println();
		System.out.println("ADD Customer....................." + ADDCUSTOMER);
		System.out.println("DISPLAY List of Customers........" + DISPLAYCUSTOMERS);
		System.out.println("ADD Inventory...................." + ADDINVENTORY);
		System.out.println("ADD STOCK to Inventory Items....." + ADDSTOCK);
		System.out.println("DISPLAY List of Inventory........" + DISPLAYINVENTORY);
		System.out.println("PLACE ORDER for Customer........." + PLACEORDER);
		System.out.println("DISPLAY ORDERS for Customer......" + DISPLAYORDERS);
		System.out.println("Exit............................." + EXIT);
		System.out.println();
	}

	/**
	 * Reads the menu choice from user.
	 * @param prompt Text asking user to enter choice
	 * @return 
	 *  <ul>
	 *    <li>{@value #ADDCUSTOMER} : Add one Customer to the collection of Customers
	 *    <li>{@value #DISPLAYCUSTOMERS} : Display the list of Customers
	 *    <li>{@value #ADDINVENTORY} : Add one Inventory to the collection of Inventory
	 *    <li>{@value #ADDSTOCK} : Add stock to an Inventory item
	 *    <li>{@value #DISPLAYINVENTORY} : Display the list of Inventory
	 *    <li>{@value #PLACEORDER} : Place an order for a Customer
	 *    <li>{@value #DISPLAYORDERS} : Display orders associated with a Customer 
	 *    <li>{@value #EXIT} : Exit the program 
	 * </ul>
	 */
	public int readIntWithPrompt(String prompt) 
	{
		System.out.print(prompt); 
		System.out.flush();
		
		int choice;
		try{
			choice = input.nextInt();
			return choice;
		} catch(InputMismatchException ex) {
			System.out.println("Invalid command!");
		}
		
		return -1;
	}

	/**
	 * Gets the input for ids
	 * @return the id
	 */
	public String getIdInput()
	{
		// TODO: ids that start with 0 are 5 digits long for some reason.

		String id = input.next();
		input.nextLine();
		
		return id;
	}

	/**
	 * Gets the input for Customer names
	 * @return the name
	 */
	public String getNameInput()
	{
		String name = input.nextLine();
		return name;
	}

	/**
	 * Gets the input for Customer addresses
	 * @return the address
	 */
	public String getAddressInput()
	{
		String address = input.nextLine();
		return address;
	}

	/**
	 * Gets the input for Inventory item descriptions
	 * @return the description
	 */
	public String getDescriptionInput()
	{
		String description = input.nextLine();
		return description;
	}

	/**
	 * Gets the input for Inventory item stock
	 * @return the stock (if the input was invalid, returns null)
	 */
	public Integer getStockInput()
	{
		Integer stock = null; 

		try {
			stock = input.nextInt();
		} catch(InputMismatchException ex) {
			System.out.println("Error: Please enter a postive amount of stock.");
			System.out.println();
			input.nextLine();
			return null;
		}

		return stock;
	}

	/**
	 * Displays content to the View
	 * @param content the content to be displayed
	 */
	public void displayInView(Object content)
	{
		System.out.println(content);
	}
}
