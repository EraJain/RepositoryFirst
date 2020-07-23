package com.beans;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;

import com.constFiles.OrderStatus;

@Entity
@Table(name="Order")
public class Order {
	
	@Id
	@Column(name = "Id", nullable = false)
	private String id;
	
	@Column(name = "order_date")
	private Instant orderDate;
	
	@Column(name = "shipment_date")
	private Instant shipmentDate;
	
	@Column(name = "shipping_Address", nullable = false)
	private Address shippingAddress;
	
	@Column(name = "Order_Status", nullable = false)
	private OrderStatus status;
	
	@Column(name = "Real_Amount", nullable = false)
	private Long RealAmount;
	
	@Column(name = "payment_Details", nullable = false)
	@OneToOne(targetEntity = Payment.class)
	private Payment paymentDetails;
	
	@Column(name = "payment_Details", nullable = false)
	@OneToOne(targetEntity = LineItem.class)
	private LineItem lineItem;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Instant orderDate) {
		this.orderDate = orderDate;
	}

	public Instant getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Instant shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Long getRealAmount() {
		return RealAmount;
	}

	public void setRealAmount(Long realAmount) {
		RealAmount = realAmount;
	}

	public Payment getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(Payment paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

}
