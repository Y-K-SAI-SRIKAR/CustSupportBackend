package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.GrievanceRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.service.GrievanceService;

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