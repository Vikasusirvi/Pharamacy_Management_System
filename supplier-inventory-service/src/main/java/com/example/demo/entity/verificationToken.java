package com.example.demo.entity;

public class verificationToken {

	private int drugAmount;
	private boolean present;
	private int drugQuantity;
	
	public verificationToken(int drugAmount, boolean present,int drugQuantity) {
		super();
		this.drugAmount = drugAmount;
		this.present = present;
		this.drugQuantity= drugQuantity;
	}
	public int getDrugQuantity() {
		return drugQuantity;
	}
	public void setDrugQuantity(int drugQuantity) {
		this.drugQuantity = drugQuantity;
	}
	@Override
	public String toString() {
		return "verificationToken [drugAmount=" + drugAmount + ", present=" + present + ", drugQuantity=" + drugQuantity
				+ "]";
	}
	public int getDrugAmount() {
		return drugAmount;
	}
	public void setDrugAmount(int drugAmount) {
		this.drugAmount = drugAmount;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public verificationToken() {
		super();
	}
	
	
	
}
