 package com.example.demo.service;

public class SMSRequest {

	private final String phoneNumber;
	private final String message;
	public SMSRequest(String phoneNumber, String message) {
		this.message=message;
		this.phoneNumber=phoneNumber;
	}
	@Override
	public String toString() {
		return "SMSRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	
	
}
