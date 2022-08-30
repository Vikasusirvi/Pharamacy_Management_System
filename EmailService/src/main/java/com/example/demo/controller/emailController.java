package com.example.demo.controller;

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
	
	@RabbitListener(queues=mqConfig.QUEUE)
	public void sendMail(email email) {
		
		service.sendBill(email.getToEmail(), email.getBody(), email.getSubject());
	}
	
}
