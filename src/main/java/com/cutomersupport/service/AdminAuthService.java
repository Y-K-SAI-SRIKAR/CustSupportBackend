package com.cutomersupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cutomersupport.dto.request.AdminLoginRequest;
import com.cutomersupport.dto.request.ForgotPasswordRequest;
import com.cutomersupport.dto.request.ResetPasswordRequest;
import com.cutomersupport.dto.response.AdminLoginResponse;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.mail.MailDispatcher;
import com.cutomersupport.model.Admin;
import com.cutomersupport.model.PasswordResetToken;
import com.cutomersupport.repository.AdminRepository;
import com.cutomersupport.repository.PasswordResetTokenRepository;
import com.cutomersupport.security.AdminSessionUtil;
import com.cutomersupport.security.PasswordCryptoUtil;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminAuthService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Autowired
	private PasswordCryptoUtil passwordCryptoUtil;

	@Autowired
	private AdminSessionUtil adminSessionUtil;

	@Autowired
	private MailDispatcher mailDispatcher;

	@Value("${app.frontend.reset-password-url}")
	private String resetPasswordBaseUrl;

	/**
	 * Login with email and password
	 */
	public ApiResponse<AdminLoginResponse> login(AdminLoginRequest request) {
		try {
			// Validate input
			if (request == null || request.getAdminEmailId() == null || request.getAdminPassword() == null) {
				return new ApiResponse<>(false, "Email and password are required.");
			}

			Optional<Admin> adminOpt = adminRepository.findByAdminEmailId(request.getAdminEmailId());

			if (adminOpt.isEmpty()) {
				return new ApiResponse<>(false, "Invalid email or password.");
			}

			Admin admin = adminOpt.get();

			// Verify password
			boolean isMatch = passwordCryptoUtil.verifyPassword(request.getAdminPassword(), admin.getAdminPasswordHash());

			if (!isMatch) {
				return new ApiResponse<>(false, "Invalid email or password.");
			}

			// Generate token
			String token = adminSessionUtil.generateToken(admin.getAdminEmailId());

			AdminLoginResponse response = new AdminLoginResponse(token, admin.getAdminEmailId(), "Login successful");

			return new ApiResponse<>(true, "Login successful", response);
		} catch (Exception e) {
			return new ApiResponse<>(false, "Login failed: " + e.getMessage());
		}
	}

	/**
	 * Send password reset link via email
	 */
	@Transactional
	public ApiResponse<Void> forgotPassword(ForgotPasswordRequest request) {
		try {
			// Validate input
			if (request == null || request.getAdminEmailId() == null || request.getAdminEmailId().trim().isEmpty()) {
				return new ApiResponse<>(false, "Email is required.");
			}

			Optional<Admin> adminOpt = adminRepository.findByAdminEmailId(request.getAdminEmailId());

			if (adminOpt.isEmpty()) {
				return new ApiResponse<>(false, "No admin found with this email.");
			}

			// Delete old reset tokens
			passwordResetTokenRepository.deleteByAdminEmail(request.getAdminEmailId());

			// Create new reset token
			String token = UUID.randomUUID().toString();

			PasswordResetToken resetToken = new PasswordResetToken();
			resetToken.setToken(token);
			resetToken.setAdminEmail(request.getAdminEmailId());
			resetToken.setExpiryDate(LocalDateTime.now().plusMinutes(30));
			resetToken.setUsed(false);

			passwordResetTokenRepository.save(resetToken);

			// Send email with reset link
			String resetLink = resetPasswordBaseUrl + "?token=" + token;
			mailDispatcher.sendPasswordResetMail(request.getAdminEmailId(), resetLink);

			return new ApiResponse<>(true, "Password reset link has been sent to your email.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error sending reset link: " + e.getMessage());
		}
	}

	/**
	 * Reset password using token and new password
	 */
	@Transactional
    // ✅ CHANGED: Return type is now ApiResponse<AdminLoginResponse>
	public ApiResponse<AdminLoginResponse> resetPassword(ResetPasswordRequest request) {
		try {
			// Validate input
			if (request == null) {
				return new ApiResponse<>(false, "Invalid request.");
			}

			if (request.getToken() == null || request.getToken().trim().isEmpty()) {
				return new ApiResponse<>(false, "Reset token is missing.");
			}

			if (request.getNewPassword() == null || request.getNewPassword().trim().isEmpty()) {
				return new ApiResponse<>(false, "New password cannot be empty.");
			}

			if (request.getConfirmPassword() == null || request.getConfirmPassword().trim().isEmpty()) {
				return new ApiResponse<>(false, "Confirm password cannot be empty.");
			}

			// Validate password length
			if (request.getNewPassword().length() < 6) {
				return new ApiResponse<>(false, "Password must be at least 6 characters.");
			}

			// Check if passwords match
			if (!request.getNewPassword().equals(request.getConfirmPassword())) {
				return new ApiResponse<>(false, "New password and confirm password do not match.");
			}

			// Find reset token
			Optional<PasswordResetToken> tokenOpt = passwordResetTokenRepository.findByToken(request.getToken());

			if (tokenOpt.isEmpty()) {
				return new ApiResponse<>(false, "Invalid or expired reset link.");
			}

			PasswordResetToken resetToken = tokenOpt.get();

			// Check if token already used
			if (resetToken.isUsed()) {
				return new ApiResponse<>(false, "This reset link has already been used.");
			}

			// Check if token expired
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime expiryTime = resetToken.getExpiryDate();

			if (expiryTime.isBefore(now)) {
				return new ApiResponse<>(false, "This reset link has expired. Please request a new one.");
			}

			// Find admin
			Optional<Admin> adminOpt = adminRepository.findByAdminEmailId(resetToken.getAdminEmail());

			if (adminOpt.isEmpty()) {
				return new ApiResponse<>(false, "Admin account not found.");
			}

			// Update password
			Admin admin = adminOpt.get();
			admin.setAdminPasswordHash(passwordCryptoUtil.hashPassword(request.getNewPassword()));
			adminRepository.save(admin);

			// Mark token as used
			resetToken.setUsed(true);
			passwordResetTokenRepository.save(resetToken);

            // ✅ NEW: Generate a fresh authentication token for auto-login
            String token = adminSessionUtil.generateToken(admin.getAdminEmailId());
            AdminLoginResponse loginResponse = new AdminLoginResponse(token, admin.getAdminEmailId(), "Password reset successful");

			return new ApiResponse<>(true, "Password has been reset successfully. You are now logged in.", loginResponse);
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error resetting password: " + e.getMessage());
		}
	}
}