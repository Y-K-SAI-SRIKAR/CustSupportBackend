package com.nexvitalssupport.controller;

import com.nexvitalssupport.dto.request.GrievanceRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.service.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grievance")
public class GrievanceController {

	@Autowired
	private GrievanceService grievanceService;

	@PostMapping("/submit")
	public ResponseEntity<ApiResponse<Void>> submitGrievance(@RequestBody GrievanceRequest request) {
		ApiResponse<Void> response = grievanceService.submitGrievance(request);
		return ResponseEntity.ok(response);
	}
}