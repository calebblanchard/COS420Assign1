package edu.usm.cos420.example1.domain;

import java.util.ArrayList;

import edu.usm.cos420.example1.service.Service;

public class CustomerList
{
	// TODO: could push this up into an interface
	ArrayList<Customer> theList; // TODO: is this the best data structure choice
	
	public CustomerList()
	{
		theList = new ArrayList<Customer>(); // initialize the list
	}
	
	// TODO: Could have this use StringBuilder instead???
	@Override
	public String toString()
	{
		String output = "List of Customers\n\n"
				+ "ID#       Name       Address\n"
				+ "-------------------------------";
		
		for(int i = 0; i < theList.size(); i++)
			output += "\n" + theList.get(i).toString();
		
		return output;
	}
	
	public ArrayList<Customer> getList()
	{
		return theList;
	}
}
