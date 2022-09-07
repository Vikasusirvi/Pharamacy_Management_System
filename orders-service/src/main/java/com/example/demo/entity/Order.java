package com.example.demo.entity;

import java.time.LocalDate;
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
	private LocalDate orderDate;
	
	@Column (name ="drugID", nullable  = false)
	private Long drugID;
	
	@Column(name ="drugName", nullable = false)
	private String drugName;
	
	@Column(name = "drugQuantity", nullable = false)
	private int drugQuantity;
	
	@Column(name = "drugPrice", nullable = false)
	private int drugPrice;
	
	@Column(name = "userID", nullable = false)
	private Long userID;
	
	@Column(name = "userEmail", nullable = false)
	private String userEmail;
	
	@Column(name = "verfied")
	private boolean verfied;
	
	@Column(name = "pickUpDate")
	private LocalDate pickUpDate;
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public Order(Long drugID, String drugName, int drugQuantity, Long userID) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.userID = userID;
	}

	public Order() {
		super();
	}

	

	public Order(Long orderID, LocalDate orderDate, Long drugID, String drugName, int drugQuantity, int drugPrice,
			Long userID, String userEmail, boolean verfied, LocalDate pickUpDate) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.drugPrice = drugPrice;
		this.userID = userID;
		this.userEmail = userEmail;
		this.verfied = verfied;
		this.pickUpDate = pickUpDate;
	}

	public Order(LocalDate orderDate, String drugName, int drugQuantity, int drugPrice, Long userID) {
		super();
		this.orderDate = orderDate;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.drugPrice = drugPrice;
		this.userID = userID;
	}
	public Long getDrugID() {
		return drugID;
	}

	public void setDrugID(Long drugID) {
		this.drugID = drugID;
	}


	public boolean isVerfied() {
		return verfied;
	}

	public void setVerfied(boolean verfied) {
		this.verfied = verfied;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
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
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", drugID=" + drugID + ", drugName="
				+ drugName + ", drugQuantity=" + drugQuantity + ", drugPrice=" + drugPrice + ", userID=" + userID
				+ ", userEmail=" + userEmail + ", verfied=" + verfied + ", pickUpDate=" + pickUpDate + "]";
	}
	
	
}
