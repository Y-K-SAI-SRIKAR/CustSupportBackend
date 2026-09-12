package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.SuggestionRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.service.SuggestionService;

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