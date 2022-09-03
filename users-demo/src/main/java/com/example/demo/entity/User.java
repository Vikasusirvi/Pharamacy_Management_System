package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS_DEMO")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userID;
	
	@Column(name="userName" , nullable = false)
	private String userName;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + "]";
	}

	public User(Long userID, String userName) {
		super();
		this.userID = userID;
		this.userName = userName;
	}

	public User() {
		super();
	}
	
	
}
