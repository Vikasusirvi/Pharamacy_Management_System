package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendBill(String toEmail, String Body, String Subject ) {
	
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setText(Body);
		message.setBcc("vikasusirvi1999@gmail.com");
		message.setSubject(Subject);
		message.setFrom("spring.pharmacy.system@gmail.com");
		mailSender.send(message);	
	}
}
//Consider defining a bean of type 'org.springframework.mail.javamail.JavaMailSender' in your configuration.