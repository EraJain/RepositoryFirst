package com.beans;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Shopping_Cart")
public class ShoppingCart {
	
	@Column
	private Instant createdDate;
	
	@Column(name = "Line_Item", nullable = false)
	@OneToOne(targetEntity = LineItem.class)
	private LineItem lineItem;

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

}
