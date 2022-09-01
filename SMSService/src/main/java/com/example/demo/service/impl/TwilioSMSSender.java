package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TwilioConfiguration;
import com.example.demo.service.SMSRequest;
import com.example.demo.service.SMSSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSMSSender implements SMSSender {

	private final TwilioConfiguration twilioConfiguration;
	@Autowired
	public TwilioSMSSender(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration=twilioConfiguration;
	}
	
	@Override
	public void sendSMS(SMSRequest smsRequest) {
	
		if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
		Message .creator(
				new PhoneNumber(smsRequest.getPhoneNumber()),
				new PhoneNumber(twilioConfiguration.getTrialNumber()),
				smsRequest.getMessage()
				).create();
		}
		else { 
			throw new IllegalArgumentException("Phone Number ["+smsRequest.getPhoneNumber()+"] is not valid");
	
		}
		}

	private boolean isPhoneNumberValid(String phoneNumber) {
		return true;
	}
}
