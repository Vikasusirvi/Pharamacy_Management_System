package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.SMSRequest;

@org.springframework.stereotype.Service
public class Service {

	private final TwilioSMSSender twilioSMSSender;
	@Autowired
	public Service(TwilioSMSSender twilioSMSSender) {
		super();
		this.twilioSMSSender = twilioSMSSender;
	}
	public void sendSMS(SMSRequest smsRequest) {
		twilioSMSSender.sendSMS(smsRequest);
	}
	
	
}
