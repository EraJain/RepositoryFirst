package com.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.beans.Customer;
import com.dao.CustomerDao;
import com.exception.CustomeServiceException;

@Service
@Qualifier("customerService")
public class CustomerService {

	@Autowired
	public CustomerDao dao;

	/**
	 * Method to add a new Customer
	 * 
	 * @throws ServiceException
	 * @param customer All the customer details
	 * @return
	 */
	@Transactional
	synchronized public void addCustomer(Customer customer) throws CustomeServiceException {
		try {
			if(this.passwordValidation(customer.getPassword())) {
				if(dao.getForFirstName(customer.getFirstName()).size() ==0) {
					dao.add(customer);
				}else {
					//error message with more user name
					throw new CustomeServiceException("User Name exist");
				}
			}else {
				//error message for password regex
				throw new CustomeServiceException("Weak Password");
			}
		} catch (Exception de) {
			throw new ServiceException(de.getLocalizedMessage());
		}

	}
	
	/**
	 * Password check
	 * */
	public boolean passwordValidation(String password) {
		 // Regex to check valid password. 
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}$"; 
        Pattern p = Pattern.compile(regex);
        if (password == null || password.isEmpty()) { 
            return false; 
        } 
        
        Matcher m = p.matcher(password);
        return m.matches(); 
	}

	/**
	 * Method to get the Customer
	 * 
	 * @throws ServiceException
	 * @param customer : for customer id
	 * @return
	 * @return
	 */
	@Transactional
	synchronized public Customer getCustomer(Customer customer) throws ServiceException {
		try {
			return dao.getCustomer(customer);
		} catch (Exception de) {
			throw new ServiceException(de.getLocalizedMessage());
		}

	}

	/**
	 * Method to modify the Customer
	 * 
	 * @throws ServiceException
	 * @param customer : for customer id, and details
	 * @return
	 * @return
	 */
	@Transactional
	synchronized public void modifyCustomer(Customer customer) throws ServiceException {
		try {
			Customer dbCustomer =  dao.getCustomer(customer);
			dbCustomer = this.modifyValues(customer, dbCustomer);
			dao.modifyCustomer(dbCustomer);
		} catch (Exception de) {
			// log for exception
			throw new ServiceException(de.getLocalizedMessage());
		}

	}
	
	/**
	 * Modify values of customer
	 * */
	private Customer modifyValues(Customer customer,Customer dbCustomer) {
		if(!customer.getFirstName().isEmpty()) {
			dbCustomer.setFirstName(customer.getFirstName());
		}
		if(!customer.getLastName().isEmpty()) {
			dbCustomer.setLastName(customer.getLastName());
		}
		if(customer.getDate() != null) {
			dbCustomer.setDate(customer.getDate());
		}
		if(customer.getEmail().isEmpty()) {
			dbCustomer.setEmail(customer.getEmail());
		}
		if(customer.getPassword() != null) {
			dbCustomer.setPassword(customer.getPassword());
		}
		return dbCustomer;
	}
	
	/**
	 * Method to remove the Customer
	 * 
	 * @throws ServiceException
	 * @param customer : for customer id
	 * @return
	 * @return
	 */
	@Transactional
	synchronized public void removeCustomer(Customer customer) throws ServiceException {
		try {
			dao.removeCustomer(customer);
		} catch (Exception de) {
			// log for exception
			throw new ServiceException(de.getLocalizedMessage());
		}

	}
}
