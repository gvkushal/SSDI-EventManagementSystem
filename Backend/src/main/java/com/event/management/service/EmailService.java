package com.event.management.service;

import java.util.List;

public interface EmailService {

	void sendEmail(String toEmail, String body, String subject);
}
