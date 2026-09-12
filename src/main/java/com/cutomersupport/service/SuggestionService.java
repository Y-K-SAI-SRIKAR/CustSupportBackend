package com.cutomersupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomersupport.dto.request.SuggestionRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.mail.MailDispatcher;
import com.cutomersupport.model.Suggestion;
import com.cutomersupport.repository.SuggestionRepository;

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