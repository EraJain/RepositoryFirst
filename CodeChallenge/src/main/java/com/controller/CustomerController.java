package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beans.Customer;
import com.exception.CustomeServiceException;
import com.service.CustomerService;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerServices;

	/**
	 * Method to add a new customer
	 * 
	 * @param : customer for details
	 */
	@PostMapping("/registration")
	@ResponseBody
	public ResponseEntity<HttpStatus> customerRegistration(@RequestParam(name = "customer") Customer customer) {
		try {
			customerServices.addCustomer(customer);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (CustomeServiceException e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Fetching for a customer
	 * 
	 * @param : customer for details
	 */
	@PostMapping("/getCustomer")
	@ResponseBody
	public ResponseEntity<?> getCustomer(@RequestParam(name = "customer") Customer customer) {
		try {
			Customer details = customerServices.getCustomer(customer);
			return new ResponseEntity(details, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Modify a customer
	 * 
	 * @param : customer for details
	 */
	@PostMapping("/modifyCustomer")
	@ResponseBody
	public ResponseEntity<HttpStatus> modifyCustomer(@RequestParam(name = "customer") Customer customer) {
		try {
			customerServices.modifyCustomer(customer);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete a customer
	 * 
	 * @param : customer for details
	 */
	@PostMapping("/removeCustomer")
	@ResponseBody
	public ResponseEntity<HttpStatus> removeCustomer(@RequestParam(name = "customer") Customer customer) {
		try {
			customerServices.removeCustomer(customer);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
