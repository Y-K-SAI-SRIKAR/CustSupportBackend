package com.nexvitalssupport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

	@Value("${spring.mail.host}")
	private String mailHost;

	@Value("${spring.mail.port}")
	private int mailPort;

	@Value("${spring.mail.username}")
	private String mailUsername;

	@Value("${spring.mail.password}")
	private String mailPassword;

	@Bean
	JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(mailHost);
		mailSender.setPort(mailPort);
		mailSender.setUsername(mailUsername);
		mailSender.setPassword(mailPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.socketFactory.port", mailPort);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.connectiontimeout", 5000);
		props.put("mail.smtp.timeout", 5000);
		props.put("mail.smtp.writetimeout", 5000);

		return mailSender;
	}
}