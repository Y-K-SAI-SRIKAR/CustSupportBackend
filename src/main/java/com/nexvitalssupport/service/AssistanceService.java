package com.nexvitalssupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nexvitalssupport.dto.request.AssistanceRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.mail.MailDispatcher;
import com.nexvitalssupport.model.Subscriber;
import com.nexvitalssupport.repository.SubscriberRepository;

@Service
public class AssistanceService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Autowired
	private MailDispatcher mailDispatcher;

	public ApiResponse<Void> subscribe(AssistanceRequest request) {
		try {
			// Check if already subscribed
			if (subscriberRepository.existsByEmailId(request.getEmailId())) {
				return new ApiResponse<>(false, "Email already subscribed");
			}

			// Save to database
			Subscriber subscriber = new Subscriber();
			subscriber.setEmailId(request.getEmailId());
			subscriber.setSubscribedAt(java.time.LocalDateTime.now());
			subscriberRepository.save(subscriber);

			// Try to send email, but don't fail if it doesn't work
			try {
				mailDispatcher.sendSubscriberWelcomeMail(request.getEmailId());
			} catch (Exception e) {
				// Log the error but don't crash the response
				System.err.println("Failed to send welcome email to " + request.getEmailId() + ": " + e.getMessage());
			}

			return new ApiResponse<>(true, "Subscribed successfully! Check your email for confirmation.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Subscription failed: " + e.getMessage());
		}
	}
}