package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.AssistanceRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.service.AssistanceService;

@RestController
@RequestMapping("/api/assistance")
public class AssistanceController {

	@Autowired
	private AssistanceService assistanceService;

	@PostMapping("/subscribe")
	public ResponseEntity<ApiResponse<Void>> subscribe(@RequestBody AssistanceRequest request) {
		ApiResponse<Void> response = assistanceService.subscribe(request);
		return ResponseEntity.ok(response);
	}
}