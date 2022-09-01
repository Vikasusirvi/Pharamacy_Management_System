package com.pharmacy.model;

public class OrderToken {
	private Long drugID;
	private String drugName;
	private int drugQuantity;
	private Long userID;
	private String emailID;
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
	
	public OrderToken(Long drugID, String drugName, int drugQuantity, Long userID, String emailID) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.userID = userID;
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		return "OrderToken [drugID=" + drugID + ", drugName=" + drugName + ", drugQuantity=" + drugQuantity
				+ ", userID=" + userID + ", emailID=" + emailID + "]";
	}
	public OrderToken() {
		super();
	}
	
}