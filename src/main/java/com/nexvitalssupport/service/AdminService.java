package com.nexvitalssupport.service;

import com.nexvitalssupport.dto.request.AdminManageRequest;
import com.nexvitalssupport.dto.request.AdminUpdateRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.model.Admin;
import com.nexvitalssupport.model.Update;
import com.nexvitalssupport.repository.AdminRepository;
import com.nexvitalssupport.repository.UpdateRepository;
import com.nexvitalssupport.security.PasswordCryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class AdminService {
	
	@Autowired
	private UpdateRepository updateRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordCryptoUtil passwordCryptoUtil;
	
	@Autowired
	private UpdateMailService updateMailService; // ✅ Inject mail service

	/**
	 * Convert String to LocalDate (handles null values)
	 */
	private LocalDate stringToLocalDate(String dateStr) {
		if (dateStr == null || dateStr.trim().isEmpty()) {
			return null;
		}
		try {
			return LocalDate.parse(dateStr);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert String to LocalDateTime (handles null values)
	 */
	private LocalDateTime stringToLocalDateTime(String dateTimeStr) {
		if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) {
			return null;
		}
		try {
			return LocalDateTime.parse(dateTimeStr);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Post an update and notify all subscribers
	 */
	public ApiResponse<Void> postUpdate(AdminUpdateRequest request, String postedByEmail) {
		try {
			Update update = new Update();
			update.setCategory(request.getCategory());
			update.setPostedBy(postedByEmail);
			update.setPostedAt(LocalDateTime.now());
			
			// Product updates
			update.setUpdateTitle(request.getUpdateTitle());
			update.setDateOfRelease(stringToLocalDate(request.getDateOfRelease()));
			update.setVersionNumber(request.getVersionNumber());
			update.setWhatChanged(request.getWhatChanged());
			update.setWhoItAffects(request.getWhoItAffects());
			
			// Workflow announcements
			update.setProtocolUpdate(request.getProtocolUpdate());
			update.setEffectiveFrom(stringToLocalDate(request.getEffectiveFrom()));
			update.setUpdateDescription(request.getUpdateDescription());
			update.setImplementingDateExpected(stringToLocalDate(request.getImplementingDateExpected()));
			
			// Maintenance notices
			update.setNoticeTitle(request.getNoticeTitle());
			update.setStartDateTime(stringToLocalDateTime(request.getStartDateTime()));
			update.setEndDateTime(stringToLocalDateTime(request.getEndDateTime()));
			update.setDetails(request.getDetails());
			
			// Partnership expansion
			update.setPartnerTitle(request.getPartnerTitle());
			update.setPartnerEffectiveFrom(stringToLocalDate(request.getPartnerEffectiveFrom()));
			update.setPartnerDescription(request.getPartnerDescription());
			
			// Policy compliance
			update.setPolicyTitle(request.getPolicyTitle());
			update.setPolicyEffectiveDate(stringToLocalDate(request.getPolicyEffectiveDate()));
			update.setPolicyDescription(request.getPolicyDescription());
			
			// Internal team announcements
			update.setTeamDate(stringToLocalDate(request.getTeamDate()));
			update.setAchievementTitle(request.getAchievementTitle());
			update.setTeamDescription(request.getTeamDescription());
			
			Update savedUpdate = updateRepository.save(update);

			// ✅ Notify all subscribers of the new update
			updateMailService.sendLatestUpdateToAllSubscribers(savedUpdate.getUpdateId());

			return new ApiResponse<>(true, "Update posted successfully and subscribers notified.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error posting update: " + e.getMessage());
		}
	}

	/**
	 * Add a new admin from AdminManageRequest
	 */
	public ApiResponse<Void> addAdmin(AdminManageRequest request) {
		try {
			if (adminRepository.existsByAdminEmailId(request.getAdminEmailId())) {
				return new ApiResponse<>(false, "An admin with this email already exists.");
			}
			
			Admin admin = new Admin();
			admin.setAdminEmailId(request.getAdminEmailId());
			admin.setAdminPasswordHash(passwordCryptoUtil.hashPassword(request.getAdminPassword()));
			admin.setCreatedAt(LocalDateTime.now());
			adminRepository.save(admin);
			
			return new ApiResponse<>(true, "Admin added successfully.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error adding admin: " + e.getMessage());
		}
	}

	/**
	 * Add a new admin from email and password parameters
	 */
	public ApiResponse<Void> addAdmin(String adminEmailId, String adminPassword) {
		try {
			if (adminRepository.existsByAdminEmailId(adminEmailId)) {
				return new ApiResponse<>(false, "An admin with this email already exists.");
			}
			
			Admin admin = new Admin();
			admin.setAdminEmailId(adminEmailId);
			admin.setAdminPasswordHash(passwordCryptoUtil.hashPassword(adminPassword));
			admin.setCreatedAt(LocalDateTime.now());
			adminRepository.save(admin);
			
			return new ApiResponse<>(true, "Admin added successfully.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error adding admin: " + e.getMessage());
		}
	}

	/**
	 * Remove an admin by email
	 */
	public ApiResponse<Void> removeAdmin(String adminEmailId) {
		try {
			Optional<Admin> adminOpt = adminRepository.findByAdminEmailId(adminEmailId);
			if (adminOpt.isEmpty()) {
				return new ApiResponse<>(false, "No admin found with this email.");
			}
			
			adminRepository.delete(adminOpt.get());
			return new ApiResponse<>(true, "Admin removed successfully.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error removing admin: " + e.getMessage());
		}
	}
}