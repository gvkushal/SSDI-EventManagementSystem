package com.event.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.event.management.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String fromAddress;

	@Override
	public void sendEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(fromAddress);
		message.setText(body);
		message.setSubject(subject);
		message.setTo(toEmail);
		mailSender.send(message);
	}
}
