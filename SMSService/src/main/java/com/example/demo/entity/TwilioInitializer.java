package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {

	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
	}
	
}
