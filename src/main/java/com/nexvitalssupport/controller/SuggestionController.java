package com.nexvitalssupport.controller;

import com.nexvitalssupport.dto.request.SuggestionRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestion")
public class SuggestionController {

	@Autowired
	private SuggestionService suggestionService;

	@PostMapping("/submit")
	public ResponseEntity<ApiResponse<Void>> submitSuggestion(@RequestBody SuggestionRequest request) {
		ApiResponse<Void> response = suggestionService.submitSuggestion(request);
		return ResponseEntity.ok(response);
	}
}