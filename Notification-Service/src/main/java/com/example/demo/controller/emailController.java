package com.example.demo.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.email;
import com.example.demo.entity.mqConfig;
import com.example.demo.service.EmailSenderService;

@RestController
public class emailController {

	@Autowired
	private EmailSenderService service;
	
	Logger logger = LoggerFactory.getLogger(emailController.class);
	
	@RabbitListener(queues=mqConfig.QUEUE)
	public void sendMail(email email) throws MessagingException {
		
		//service.sendBill(email.getToEmail(), email.getBody(), email.getSubject());
		service.sendBillWithSignature(email.getToEmail(), email.getBody(), email.getSubject(), "C:\\\\Users\\\\91831\\\\Desktop\\\\logo.gif");
	
	logger.info("Email has been sent to {} regarding his/her order {}",email.getToEmail(),email.getBody());
	
	}
	//"C:\Users\91831\Desktop\logo_3_1.png"
}
