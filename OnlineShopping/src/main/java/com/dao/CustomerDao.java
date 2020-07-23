package com.dao;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Repository;

import com.beans.Customer;
import com.exceptions.DAOException;
import com.generic.GenericDao;

@Repository
public class CustomerDao extends GenericDao {

	/**
	   * Method to add a new customer
	   * @throws DAOException
	   * @param customer : All the customer details
	   * @return 
	   */
	public void customerRegistration(Customer customer) throws DAOException{
		try {
			this.addCustomer(customer);
		} catch (Exception e) {
			//log the exception details
			throw new DAOException(e.getLocalizedMessage());
		}
	}
	
	/**
	   * method to find a customer
	   * @throws DAOException
	   * @param customer : customer Id
	   * @return Customer
	   */
	public Customer getCustomer(Customer customer) throws DAOException{
		try {
			return this.findCustomer(customer);
		} catch (Exception e) {
			//log the exception details
			throw new DAOException(e.getLocalizedMessage());
		}
	}
	
	/**
	   * method to update Customer details
	   * @throws DAOException
	   * @param customer : customer details
	   * @return
	   */
	public void modifyCustomer(Customer customer) throws DAOException{
		try {
			this.updateCustomer(customer);
		} catch (Exception e) {
			//log the exception details
			throw new DAOException(e.getLocalizedMessage());
		}
	}

}
