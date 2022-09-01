package com.pharmacy.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;

	private Long userPhNumber;

	private String userEmail;
	
	//default constructor for JSON Parsing
	public JwtRequest()
	{
	}

	

	public JwtRequest(String username, String password, Long userPhNumber, String userEmail) {
		super();
		this.username = username;
		this.password = password;
		this.userPhNumber = userPhNumber;
		this.userEmail = userEmail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	   public Long getUserPhNumber() {
			return userPhNumber;
		}

		public void setUserPhNumber(Long userPhNumber) {
			this.userPhNumber = userPhNumber;
		}
		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
}