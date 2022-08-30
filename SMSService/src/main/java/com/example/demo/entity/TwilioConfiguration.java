package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {

	private String accountSid;
	private String authToken;
	private String trialNumber;
	public TwilioConfiguration() {
		super();
	}
	public TwilioConfiguration(String accountSid, String authToken, String trialNumber) {
		super();
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.trialNumber = trialNumber;
	}
	@Override
	public String toString() {
		return "TwilioConfiguration [accountSid=" + accountSid + ", authToken=" + authToken + ", trialNumber="
				+ trialNumber + "]";
	}
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getTrialNumber() {
		return trialNumber;
	}
	public void setTrialNumber(String trialNumber) {
		this.trialNumber = trialNumber;
	}
}
