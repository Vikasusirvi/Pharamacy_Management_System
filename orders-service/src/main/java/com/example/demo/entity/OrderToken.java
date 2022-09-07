package com.example.demo.entity;

public class OrderToken {

	private Long drugID;
	private String drugName;
	private int drugQuantity;
	private Long userID;
	private String userEmail;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Long getDrugID() {
		return drugID;
	}
	public void setDrugID(Long drugID) {
		this.drugID = drugID;
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
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "OrderToken [drugID=" + drugID + ", drugName=" + drugName + ", drugQuantity=" + drugQuantity
				+ ", userID=" + userID + ", userEmail=" + userEmail + "]";
	}
	public OrderToken(Long drugID, String drugName, int drugQuantity, Long userID) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.userID = userID;
	}
	public OrderToken() {
		super();
	}
	public OrderToken(Long drugID, String drugName, int drugQuantity, Long userID, String userEmail) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.userID = userID;
		this.userEmail = userEmail;
	}
	
	
}
