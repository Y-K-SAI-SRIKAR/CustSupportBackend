package com.nexvitalssupport.controller;

import com.nexvitalssupport.dto.request.AdminLoginRequest;
import com.nexvitalssupport.dto.request.ForgotPasswordRequest;
import com.nexvitalssupport.dto.request.ResetPasswordRequest;
import com.nexvitalssupport.dto.response.AdminLoginResponse;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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