package com.pharmacy.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    
	@Column
	private Long userPhNumber;

	@Column
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

	public UserDao(long id, String username, String password, Long userPhNumber, String userEmail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userPhNumber = userPhNumber;
		this.userEmail = userEmail;
	}

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

