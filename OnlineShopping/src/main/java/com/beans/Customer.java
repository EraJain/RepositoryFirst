package com.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "Id", nullable = false)
	private String id;
	
	@Column(name = "Address", length = 512)
	private Address address;
	
	@Column(name = "Phone_Number", nullable = false, length = 10)
	private Long phoneNumber;
	
	@Column(name = "Email", nullable = false)
	private String email;
	
	@OneToOne(targetEntity=Account.class)
	private Account accountDetails;
	
	@OneToMany(targetEntity=Order.class)
	private List<Order> listOfOrders;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(Account accountDetails) {
		this.accountDetails = accountDetails;
	}

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	
}
