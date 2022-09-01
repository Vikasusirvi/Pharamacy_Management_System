package com.example.demo.controller;
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
	
	@RabbitListener(queues=mqConfig.QUEUE)
	public void sendSMS(SMS sms) {
		SMSRequest smsRequest = new SMSRequest("+91 63612 48190",sms.getMessage());
		service.sendSMS(smsRequest);
	}
	
}
