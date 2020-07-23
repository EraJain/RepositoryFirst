package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.example.bean.Customer;
import com.exception.DaoException;

@Service
@Qualifier("customerService")
public class CustomerService {
	
	@Autowired
	public CustomerDao dao;
	
	@Transactional
	synchronized public void customerRegistration(Customer customer) {
		try {
			
		}catch(Exception ex) {
			
		}
		dao.add(customer);
	}

}
