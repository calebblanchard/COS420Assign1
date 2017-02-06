package edu.usm.cos420.example1;

import edu.usm.cos420.example1.controller.CItemController;
import edu.usm.cos420.example1.service.Service;
import edu.usm.cos420.example1.service.impl.CustomerService;
import edu.usm.cos420.example1.service.impl.InventoryService;
import edu.usm.cos420.example1.view.impl.CItemView;

/**
 * Top level application class that coordinates the calls to View and Controller
 */
public class App
{
    /**
     * Entry point for application : calls {@link #provideCItemAccess()}
     * @param args main program arguments, currently not used
     */
	public static void main(String[] args)
    {
		Service customerService = new CustomerService(); // the customer service object
		Service inventoryService = new InventoryService(); // the inventory service object
		
		CItemView citemView = new CItemView(); // the view
		CItemController controller = new CItemController(citemView, customerService, inventoryService); // the controller
		
		controller.provideCItemAccess();
    }
}
