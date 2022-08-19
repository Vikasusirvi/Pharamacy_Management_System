package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders_pharma")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderID;
	
	@Column(name="orderDate", nullable = false)
	private Long orderDate;
	
	@Column(name ="drugName", nullable = false)
	private String drugName;
	
	@Column(name = "drugQuantity", nullable = false)
	private int drugQuantity;
	
	@Column(name = "drugPrice", nullable = false)
	private int drugPrice;
	
	@Column(name = "userID", nullable = false)
	private Long userID;

	public Order() {
		super();
	}

	public Order(Long orderID, Long orderDate, String drugName, int drugQuantity, int drugPrice, Long userID) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.drugPrice = drugPrice;
		this.userID = userID;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugQuantity() {
		return drugQuantity;
	}

	public void setDrugQuantity(int drugQuantity) {
		this.drugQuantity = drugQuantity;
	}

	public int getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(int drugPrice) {
		this.drugPrice = drugPrice;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", drugName=" + drugName + ", drugQuantity="
				+ drugQuantity + ", drugPrice=" + drugPrice + ", userID=" + userID + "]";
	}
	
	
}
