package com.nexvitalssupport.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendHtmlMail(String toEmail, String subject, String htmlBody) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(toEmail);
			helper.setSubject(subject);
			helper.setText(htmlBody, true);
			helper.setFrom("noreply.nexvitals@gmail.com");

			mailSender.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException("Failed to send mail to " + toEmail, e);
		}
	}
}