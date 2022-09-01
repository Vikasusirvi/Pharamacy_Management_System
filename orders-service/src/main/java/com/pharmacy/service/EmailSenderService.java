package com.pharmacy.service;

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
		message.setBcc("nikhilcs2000m@gmail.com");
		message.setText(Body);
		message.setSubject(Subject);
		message.setFrom("spring.pharmacy.system@gmail.com");
		mailSender.send(message);	
	}
}
