package com.event.management.service;

import java.util.List;

public interface EmailService {

	void sendEmail(List<String> toEmails, String body, String subject);
}
