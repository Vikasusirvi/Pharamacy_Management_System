package com.pharmacy.entity;

public class email {

	private String toEmail;
	private String body;
	private String subject;
	@Override
	public String toString() {
		return "email [toEmail=" + toEmail + ", body=" + body + ", subject=" + subject + "]";
	}
	public email() {
		super();
	}
	public email(String toEmail, String body, String subject) {
		super();
		this.toEmail = toEmail;
		this.body = body;
		this.subject = subject;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
