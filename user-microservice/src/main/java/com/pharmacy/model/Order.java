package com.pharmacy.model;

import java.time.LocalDate;

public class Order {

    private Long orderID;
    private LocalDate orderDate;
    private Long drugID;
    private String drugName;
    private int drugQuantity;
    private int drugPrice;
    private Long userID;
    private String emailID;
    private boolean verfied;
    private LocalDate pickUpDate;

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
    
    public Order(Long orderID, LocalDate orderDate, Long drugID, String drugName, int drugQuantity, int drugPrice,
			Long userID, String emailID, boolean verfied, LocalDate pickUpDate) {
		super();
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.drugPrice = drugPrice;
		this.userID = userID;
		this.emailID = emailID;
		this.verfied = verfied;
		this.pickUpDate = pickUpDate;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
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

    public Order(Long orderID, LocalDate orderDate, String drugName, int drugQuantity, int drugPrice, Long userID) {
        super();
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.drugName = drugName;
        this.drugQuantity = drugQuantity;
        this.drugPrice = drugPrice;
        this.userID = userID;
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
                + ", verfied=" + verfied + ", pickUpDate=" + pickUpDate + "]";
    }


}