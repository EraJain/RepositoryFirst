package com.dao;

import org.springframework.stereotype.Repository;

import com.example.bean.Customer;
import com.exception.DaoException;

@Repository
public class CustomerDao extends GenericDao {

	public void customerRegistration(Customer customer) throws  DaoException {
		try {
			this.add(customer);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

}
