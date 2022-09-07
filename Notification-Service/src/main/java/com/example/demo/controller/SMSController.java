package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SMS;
import com.example.demo.entity.mqConfig;
import com.example.demo.service.SMSRequest;
import com.example.demo.service.impl.Service;

@RestController
public class SMSController {

	@Autowired
	private Service service;
	
	Logger logger = LoggerFactory.getLogger(SMSController.class);
	
	@RabbitListener(queues=mqConfig.QUEUE)
	public void sendSMS(SMS sms) {
		SMSRequest smsRequest = new SMSRequest("+91 83103 58465",sms.getMessage());
		service.sendSMS(smsRequest);
		
		logger.info("SMS notification regarding his/her order {} has been sent to +91 8310358465",sms.getMessage());
	}
	
}
