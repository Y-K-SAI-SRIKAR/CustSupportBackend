package com.nexvitalssupport.controller;

import com.nexvitalssupport.dto.request.AssistanceRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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