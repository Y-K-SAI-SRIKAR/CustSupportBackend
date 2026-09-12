package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.AdminManageRequest;
import com.cutomersupport.dto.request.AdminUpdateRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.security.AdminSessionUtil;
import com.cutomersupport.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminSessionUtil adminSessionUtil;

	@PostMapping("/updates/post")
	public ResponseEntity<ApiResponse<Void>> postUpdate(
			@RequestBody AdminUpdateRequest request,
			@RequestHeader("Authorization") String authHeader) {

		String adminEmail = validateAndExtractEmail(authHeader);

		if (adminEmail == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse<>(false, "Invalid or expired session. Please log in again."));
		}

		ApiResponse<Void> response = adminService.postUpdate(request, adminEmail);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<Void>> addAdmin(
			@RequestBody AdminManageRequest request,
			@RequestHeader("Authorization") String authHeader) {

		String adminEmail = validateAndExtractEmail(authHeader);

		if (adminEmail == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse<>(false, "Invalid or expired session. Please log in again."));
		}

		ApiResponse<Void> response = adminService.addAdmin(request);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/remove")
	public ResponseEntity<ApiResponse<Void>> removeAdmin(
			@RequestParam("adminEmailId") String adminEmailId,
			@RequestHeader("Authorization") String authHeader) {

		String requesterEmail = validateAndExtractEmail(authHeader);

		if (requesterEmail == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse<>(false, "Invalid or expired session. Please log in again."));
		}

		ApiResponse<Void> response = adminService.removeAdmin(adminEmailId);
		return ResponseEntity.ok(response);
	}

	private String validateAndExtractEmail(String authHeader) {
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return null;
		}

		String token = authHeader.substring(7);

		if (!adminSessionUtil.isTokenValid(token)) {
			return null;
		}

		return adminSessionUtil.extractAdminEmailId(token);
	}
}