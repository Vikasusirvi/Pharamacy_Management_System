package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long drugID;
	
	@Column(name="drugName", nullable = false)
	private String drugName;
	
	@Column(name ="drugQuantity", nullable = false)
	private int drugQuantity;
	
	@Column(name ="supplierName", nullable = false)
	private String supplierName;

	public Inventory() {
		super();
	}

	public Inventory(Long drugID, String drugName, int drugQuantity, String supplierName) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.supplierName = supplierName;
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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Inventory [drugID=" + drugID + ", drugName=" + drugName + ", drugQuantity=" + drugQuantity
				+ ", supplierName=" + supplierName + "]";
	}
}
