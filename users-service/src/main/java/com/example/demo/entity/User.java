package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_pharma")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userID;
	
	@Column(name="userName" , nullable = false)
	private String userName;
	
	@Column(name = "userPhoneNumber" , nullable = false)
	private Long userPhoneNumber;
	
	@Column(name ="userEmail" , nullable = false)
	private String userEmail;
	
	@Column(name ="password" , nullable = false)
	private String password;

	public User(Long userID, String userName, Long userPhoneNumber, String userEmail, String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userEmail = userEmail;
		this.password = password;
	}

	public User() {
		super();
	}

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

	public Long getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(Long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [userID=" + userID + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber
				+ ", userEmail=" + userEmail + ", password=" + password + "]";
	}
	
	
	

}
