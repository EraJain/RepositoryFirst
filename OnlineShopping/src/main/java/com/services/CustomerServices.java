package com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Customer;
import com.beans.Order;
import com.dao.CustomerDao;

@Service
public class CustomerServices {
	
	@Autowired
	CustomerDao dao;
	
	 /**
	   * Method to add a new Customer
	   * @throws ServiceException
	   * @param customer All the customer details
	   * @return 
	   */
	@Transactional
	synchronized public void addCustomer(Customer customer) throws ServiceException{
		try {
			dao.customerRegistration(customer);
		}catch(Exception de) {
			//log for exception
			throw new ServiceException(de.getLocalizedMessage());
		}
		
	}

	/**
	   * Method to add a new Order
	   * @throws ServiceException
	   * @param customer : For Customer Id
	   * @param	orders : All the orders customer wants to place
	   * @return 
	   */
	@Transactional
	synchronized public void addOrder(Customer customer, List<Order> orders)  throws ServiceException{
		try {
			Customer dbCust = dao.getCustomer(customer);
			dbCust.getListOfOrders().addAll(orders);
			dao.modifyCustomer(customer);
		}catch(Exception de) {
			//log for exception
			throw new ServiceException(de.getLocalizedMessage());
		}
	}

}
