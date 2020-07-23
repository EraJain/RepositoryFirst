package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.beans.Customer;
import com.exception.DaoException;

@Repository
public class CustomerDao extends GenericDao {

	//add customer
	public void customerRegistration(Customer customer) throws  DaoException {
		try {
			this.add(customer);
		} catch (Exception ex) {
			throw new DaoException(ex.getLocalizedMessage());
		}
	}
	
	//fetch customer
	public Customer getCustomer(Customer customer) throws  DaoException {
		try {
			return this.get(customer);
		} catch (Exception ex) {
			throw new DaoException(ex.getLocalizedMessage());
		}
	}
	
	//update customer
	public void modifyCustomer(Customer customer) throws  DaoException {
		try {
			this.update(customer);
		} catch (Exception ex) {
			throw new DaoException(ex.getLocalizedMessage());
		}
	}
	
	//delete customer
	public void removeCustomer(Customer customer) throws  DaoException {
		try {
			this.delete(customer);
		} catch (Exception ex) {
			throw new DaoException(ex.getLocalizedMessage());
		}
	}
	
	//get all customers with firstname
	public List<Customer> getCustomerFirstName(String firstName) throws  DaoException {
		try {
			return this.getForFirstName(firstName);
		} catch (Exception ex) {
			throw new DaoException(ex.getLocalizedMessage());
		}
	}
	
}
