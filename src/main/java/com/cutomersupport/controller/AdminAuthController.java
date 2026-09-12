package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.AdminLoginRequest;
import com.cutomersupport.dto.request.ForgotPasswordRequest;
import com.cutomersupport.dto.request.ResetPasswordRequest;
import com.cutomersupport.dto.response.AdminLoginResponse;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.service.AdminAuthService;

@RestController
@RequestMapping("/api/auth")
public class AdminAuthController {

	@Autowired
	private AdminAuthService adminAuthService;

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<AdminLoginResponse>> login(@RequestBody AdminLoginRequest request) {
		ApiResponse<AdminLoginResponse> response = adminAuthService.login(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<ApiResponse<Void>> forgotPassword(@RequestBody ForgotPasswordRequest request) {
		ApiResponse<Void> response = adminAuthService.forgotPassword(request);
		return ResponseEntity.ok(response);
	}

    // ✅ CHANGED: Return type is now ApiResponse<AdminLoginResponse>
	@PostMapping("/reset-password")
	public ResponseEntity<ApiResponse<AdminLoginResponse>> resetPassword(@RequestBody ResetPasswordRequest request) {
		ApiResponse<AdminLoginResponse> response = adminAuthService.resetPassword(request);
		return ResponseEntity.ok(response);
	}
}