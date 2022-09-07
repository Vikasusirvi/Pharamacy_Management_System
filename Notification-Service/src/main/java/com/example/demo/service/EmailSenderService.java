package com.example.demo.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	public void sendBillWithSignature(String toEmail, String Body, String Subject,String logo) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setCc("vikasusirvi1999@gmail.com");
		mimeMessageHelper.setText(Body);
		mimeMessageHelper.setSubject(Subject);
		mimeMessageHelper.setFrom("spring.pharmacy.system@gmail.com");
		FileSystemResource fileSystem = new FileSystemResource(new File(logo));
		mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
		mailSender.send(mimeMessage);
		
		
	}
}
//Consider defining a bean of type 'org.springframework.mail.javamail.JavaMailSender' in your configuration.