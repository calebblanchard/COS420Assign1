//package edu.usm.cos420.example1.service.impl;
//
//import java.util.Iterator;
//import java.util.List;
//
//import edu.usm.cos420.example1.dao.domain.CItemDao;
//import edu.usm.cos420.example1.domain.CItem;
//import edu.usm.cos420.example1.service.Service;
//
///**
// *  The Example1 Service Layer Implementation is based a design pattern
// *      which aims to organize the functionality of the application into logical units 
// *      that are typically layered on top of much of the low level functionality of the 
// *      application. This organization helps support service oriented architectures. 
// */
//public class ServiceImpl implements Service 
//{
//	CItemDao dao;
//
//	/**
//	 * Default Constructor creates a default CItemDao object 
//	 */
//	public ServiceImpl()
//	{
//		this.dao = new CItemDao();	
//	}
//
//	/**
//	 * Constructor with the DAO provided 
//	 * @param dao Data Access Object to use in the service
//	 */
//	public ServiceImpl(CItemDao dao)
//	{
//		this.dao = dao;	
//	}
//
//	/**
//	 * Add a randomly generated CItem element to the repository
//	 */
//	public boolean add(Object o) 
//	{
//		int randomNum = 1 + (int)(Math.random()*100000); 
//		CItem anItem = new CItem(new Long(randomNum));
//		dao.add(anItem);
//		return true;
//	}
//}
