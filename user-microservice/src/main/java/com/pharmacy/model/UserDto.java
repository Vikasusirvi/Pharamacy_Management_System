package com.pharmacy.model;

public class UserDto {
	
    private String username;
    private String password;
	private Long userPhNumber;
	private String userEmail;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
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

	public UserDto(String username, String password, Long userPhNumber, String userEmail) {
		super();
		this.username = username;
		this.password = password;
		this.userPhNumber = userPhNumber;
		this.userEmail = userEmail;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
