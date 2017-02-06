package edu.usm.cos420.example1.controller;

import java.util.Calendar;
import java.util.List;

import edu.usm.cos420.example1.domain.CItem;
import edu.usm.cos420.example1.domain.Customer;
import edu.usm.cos420.example1.domain.Inventory;
import edu.usm.cos420.example1.domain.InventoryList;
import edu.usm.cos420.example1.service.Service;
import edu.usm.cos420.example1.view.impl.CItemView;

/**
 *   A Controller class to execute user's menu choice.
 *     List of possible choices can be found at {@link edu.usm.cos420.example1.view.TextUI}
 */	 
public class CItemController 
{
	private Service customerService; // for customer services
	private Service inventoryService; // for inventory services

	private List<Customer> customerList; // stores the Customers read from the repository
	private InventoryList inventoryList; // stores the Inventory items read from the repository

	private CItemView view; // the view

	/**
	 * Constructor : pass in a service class which can provide access to cItem operations. 
	 * @param view 
	 * @param customerService
	 * @param inventoryService
	 */
	@SuppressWarnings("unchecked")
	public CItemController(CItemView view, Service customerService, Service inventoryService)
	{
		this.view = view;
		this.customerService = customerService;
		this.inventoryService = inventoryService;

		this.customerList = (List<Customer>) customerService.getList(); 
		this.inventoryList = new InventoryList((List<Inventory>) inventoryService.getList()); 
	}

	/**
	 * Allow the user to access the CItem collection
	 */
	public void provideCItemAccess()
	{
		int choice = CItemView.NO_CHOICE;
		while (choice != CItemView.EXIT) 
		{
			view.displayMenu();
			choice = view.readIntWithPrompt("Enter choice: ");
			if(choice == -1)
			{
				choice = CItemView.EXIT;
				view.displayMenu();
				continue;
			}
			else
				executeChoice(choice);
		}  	
	}

	/**
	 *   Performs the branching logic to call appropriate functions to satisfy user choice
	 *   @param choice represents the user selection of action they want accomplished. 
	 */
	public void executeChoice (int choice) 
	{
		System.out.println();
		if (choice == CItemView.ADDCUSTOMER)
			addCustomer();
		else if(choice == CItemView.ADDINVENTORY)
			addInventory();			
		else if(choice == CItemView.ADDSTOCK)
			addStock();
		else if(choice == CItemView.PLACEORDER)
			placeOrder();
		else if(choice == CItemView.DISPLAYCUSTOMERS)
			displayCustomerList();
		else if(choice == CItemView.DISPLAYINVENTORY)
			displayInventoryList();
		else if(choice == CItemView.DISPLAYORDERS)
			displayCustomerOrder();
		else if (choice == CItemView.EXIT)
			view.displayInView("Goodbye.");
		else
			view.displayInView("Invalid command!");
	}

	/**
	 * Performs Add Customer tasks
	 */
	public void addCustomer()
	{
		String id = null;
		String name = null;
		String address = null;

		view.displayInView("Please enter a 6 digit id#:");
		id = view.getIdInput();

		if(idError(id, customerList) != null)
		{
			view.displayInView(idError(id, customerList));
			return;
		}

		view.displayInView("Please enter a name:");
		name = view.getNameInput();

		if(nameError(name) != null)
		{
			view.displayInView(nameError(name));
			return;
		}

		view.displayInView("Please enter an Address:");
		address = view.getAddressInput();

		if(id != null && name != null && address != null)
		{
			Customer aCustomer = new Customer(id, name, address);
			customerList.add(aCustomer);
			customerService.add(aCustomer);
			System.out.println("Added one customer: " + aCustomer.getId());
			System.out.println();
			displayCustomerList();
		}
	}

	/**
	 * Performs Add Inventory tasks
	 */
	public void addInventory()
	{
		String id = null;
		String description = null;
		Integer stock = null;

		view.displayInView("Please enter a 6 digit id#:");
		id = view.getIdInput();

		if(idError(id, inventoryList.getList()) != null)
		{
			view.displayInView(idError(id, inventoryList.getList()));
			return;
		}

		view.displayInView("Please enter a description:");
		description = view.getDescriptionInput();

		while(stock == null)
		{
			view.displayInView("Please enter an amount of stock:");
			stock = view.getStockInput();
		}
		
		if(idError(id, inventoryList.getList()) == null)
		{
			Inventory anInventory = new Inventory(id, description, stock);
			inventoryList.add(anInventory);
			inventoryService.add(anInventory);
			System.out.println("Added one inventory: " + anInventory.getId());
			System.out.println();
			displayInventoryList();
		}
	}

	/**
	 * Performs Add Stock tasks
	 */
	public void addStock()
	{
		String id = null;
		Inventory currentItem = null;

		view.displayInView("Please enter an item id number:");
		id = view.getIdInput();
			
		if(String.valueOf(id).length() != 6)
		{
			view.displayInView("Error: IDs must be 6 digits long.");
			return;
		}
			
		if(checkForId(inventoryList.getList(), id) == null)
		{
			view.displayInView("Sorry, we don't currently carry that item.");
			return;
		}
		else
			currentItem = (Inventory) checkForId(inventoryList.getList(), id);

		Integer newStock = null;
			
		view.displayInView("Please enter an amount of stock:");
		newStock = view.getStockInput();	
					
		if(stockError(newStock) != null)
		{
			view.displayInView(stockError(newStock));
			return;
		}
				
		currentItem.addStock(newStock);
		inventoryService.update(currentItem);
		view.displayInView("Added " + newStock + " stock to item " + currentItem + ".");
		System.out.println();
		displayInventoryList();
	}

	/**
	 * Performs Place Order tasks
	 */
	public void placeOrder()
	{
		Customer customerPlacingOrder = null;

		customerPlacingOrder = retrieveCustomer();
		
		// in case we fail to find a Customer
		if(customerPlacingOrder == null)
			return;
		
		InventoryList orderList = processOrder();
		
		customerPlacingOrder.addOrder(orderList);
		customerService.update(customerPlacingOrder);

		System.out.println("Placed order for customer " + customerPlacingOrder);
	}
	
	/**
	 * Gets a Customer from the repository (if it exists)
	 * @return a Customer if it exists
	 */
	public Customer retrieveCustomer()
	{
		String id = null;
		
		view.displayInView("Please enter a customer id#:");
		id = view.getIdInput();
					
		if(String.valueOf(id).length() != 6)
		{
			view.displayInView("Error: Please enter a 6 digit number.");
			return null;
		}
					
		if(checkForId(customerList, id) == null)
		{
			view.displayInView("Sorry, that customer doesn't exist.");
			return null;
		}
		else
			return (Customer) customerService.find(id);
	}
	
	/**
	 * Processes an order for a Customer
	 * @return the order list for a Customer
	 */
	public InventoryList processOrder()
	{
		String id = null;
		Integer stock = null;
		InventoryList orderList = new InventoryList(getTodaysDate());
		
		while(id == null)
		{
			view.displayInView("Please enter an item id#:");
			id = view.getIdInput();

			if(checkForId(inventoryList.getList(), id) == null)
			{
				view.displayInView("Sorry, we don't carry that item.");
				id = null;
				continue;
			}
			else
			{
				Inventory itemInInventory = (Inventory) inventoryService.find(id); // reference to the item within the inventory
				Inventory itemToAdd = (Inventory) inventoryService.find(id); // item instance that will be added to the order list
				
				view.displayInView("Please enter how much stock you want:");
				stock = view.getStockInput();
				
				if(stock > itemInInventory.getStock())
					view.displayInView("Sorry, we only have " + itemToAdd.getStock() + " of " + id + " in stock.");
				else
				{
					itemToAdd.setStock(stock);
					itemInInventory.removeStock(stock);
					inventoryService.update(itemInInventory);
					orderList.add(itemToAdd);
				}
				
				view.displayInView("Want to enter another item? (y/n)");
				id = view.getIdInput(); // TODO: how to handle input that isn't "y" or "n"?
				
				if(id.equalsIgnoreCase("y"))
				{
					id = null;
					continue;
				}
				else if(id.equalsIgnoreCase("n"))
					return orderList;
			}
		}
		
		return null; // will never get reached
	}
	
	/**
	 * Gets todays date as a Calendar object
	 * @return the Calendar object representation for today's date
	 */
	public static Calendar getTodaysDate()
	{
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DATE, 0);

		return date;
	}
	
	/**********************
	 DISPLAYING METHODS
	 **********************/
	
	/**
	 * Displays the Customer list
	 */
	public void displayCustomerList() 
	{
		view.displayInView("\n" + customerService.getList());
	}

	/**
	 * Displays the Inventory list
	 */
	public void displayInventoryList()
	{
		view.displayInView("\n" + inventoryService.getList());
	}

	/**
	 * Displays the Order list for a Customer
	 * @param c the customer
	 */
	public void displayCustomerOrder()
	{
		String id = null;
		
		view.displayInView("Please enter a customer id#:");

		id = view.getIdInput();
	
		if(checkForId(customerList, id) == null)
		{
			view.displayInView("Sorry, that customer doesn't exist.");
			return;
		}

		Customer c = (Customer) customerService.find(id);		
		view.displayInView("\n" + c.getOrdersList());
	}
	
	
	/**********************
	 ERROR CHECKING METHODS
	 **********************/
	
	/**
	 * Checks whether a CItem with a given id is already in the list of CItems
	 * @param list the list of CItems to check through
	 * @param id the id to check the list for
	 * @return a CItem if one with that given id is in the list, null if there isn't one
	 */
	public static CItem checkForId(List<? extends CItem> list, String id)
	{
		for(int i = 0; i < list.size(); i++)
		{
			CItem currentItem = list.get(i);

			if(currentItem.getId().equals(id)) 
				return currentItem;
		}

		return null;
	}
	
	/**
	 * Validate id input
	 * @param id the input for id
	 * @return null if valid, an appropriate error message if not 
	 */
	public String idError(String id, List<? extends CItem> list)
	{
		int i = 0;
		
		if(id.length() != 6)
			return "Error: Invalid ID# (should be 6 digits long)";
		if(checkForId(list, id) != null)
			return "Error: That id has already been taken. Please choose another one.";

		return null;
	}

	/**
	 * Validate name input
	 * @param name the input for name
	 * @return null if valid, an appropriate error message if not 
	 */
	public String nameError(String name)
	{
		if(!name.matches("[a-zA-Z ]+") || name == null || name.isEmpty())
			return "Error: Names can only contain letters.";

		return null;
	}

	/**
	 * Validate stock input
	 * @param stock the input for stock
	 * @return null if valid, an appropriate error message if not 
	 */
	public String stockError(Integer stock)
	{
		if(stock < 1)
			return "Error: Your stock must be positive.";

		return null;
	}
}
