package com.pharmacy.entity;

public class SMS {

	private String message;

	public SMS() {
		super();
	}

	public SMS(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "sms [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
