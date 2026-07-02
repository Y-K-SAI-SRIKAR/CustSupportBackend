package com.nexvitalssupport.service;

import com.nexvitalssupport.dto.request.SuggestionRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.mail.MailDispatcher;
import com.nexvitalssupport.model.Suggestion;
import com.nexvitalssupport.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SuggestionService {

	@Autowired
	private SuggestionRepository suggestionRepository;

	@Autowired
	private MailDispatcher mailDispatcher;

	public ApiResponse<Void> submitSuggestion(SuggestionRequest request) {

		Suggestion suggestion = new Suggestion();
		suggestion.setSuggestorName(request.getName());
		suggestion.setSuggestorEmailId(request.getEmailId());
		suggestion.setSuggestion(request.getSuggestion());
		suggestion.setSuggestedAt(LocalDateTime.now());

		suggestionRepository.save(suggestion);

		mailDispatcher.sendSuggestionAckMail(request.getEmailId(), request.getName());

		return new ApiResponse<>(true, "Thanks for your suggestion! We've sent you a confirmation mail.");
	}
}