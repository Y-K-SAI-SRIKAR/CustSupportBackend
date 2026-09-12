package com.cutomersupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cutomersupport.dto.request.AdminManageRequest;
import com.cutomersupport.dto.request.AdminUpdateRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.model.Admin;
import com.cutomersupport.model.Update;
import com.cutomersupport.repository.AdminRepository;
import com.cutomersupport.repository.UpdateRepository;
import com.cutomersupport.security.PasswordCryptoUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private UpdateMailService updateMailService;


    /**
     * Convert String to LocalDate.
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
     * Convert String to LocalDateTime.
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
     * Post an update and notify all subscribers.
     */
    public ApiResponse<Void> postUpdate(
            AdminUpdateRequest request,
            String postedByEmail) {

        try {

            Update update = new Update();

            update.setCategory(request.getCategory());
            update.setPostedBy(postedByEmail);
            update.setPostedAt(LocalDateTime.now());


            // ---------- Product Updates ----------

            update.setUpdateTitle(
                    request.getUpdateTitle()
            );

            update.setDateOfRelease(
                    stringToLocalDate(
                        request.getDateOfRelease()
                    )
            );

            update.setVersionNumber(
                    request.getVersionNumber()
            );

            update.setWhatChanged(
                    request.getWhatChanged()
            );

            update.setWhoItAffects(
                    request.getWhoItAffects()
            );


            // ---------- Workflow Updates ----------

            update.setWorkflowUpdate(
                    request.getWorkflowUpdate()
            );

            update.setEffectiveFrom(
                    stringToLocalDate(
                        request.getEffectiveFrom()
                    )
            );

            update.setUpdateDescription(
                    request.getUpdateDescription()
            );

            update.setImplementationDate(
                    stringToLocalDate(
                        request.getImplementationDate()
                    )
            );


            // ---------- Maintenance Notices ----------

            update.setNoticeTitle(
                    request.getNoticeTitle()
            );

            update.setStartDateTime(
                    stringToLocalDateTime(
                        request.getStartDateTime()
                    )
            );

            update.setEndDateTime(
                    stringToLocalDateTime(
                        request.getEndDateTime()
                    )
            );

            update.setDetails(
                    request.getDetails()
            );


            // ---------- Feature Releases ----------

            update.setFeatureTitle(
                    request.getFeatureTitle()
            );

            update.setFeatureReleaseDate(
                    stringToLocalDate(
                        request.getFeatureReleaseDate()
                    )
            );

            update.setFeatureDescription(
                    request.getFeatureDescription()
            );


            // ---------- Policy Updates ----------

            update.setPolicyTitle(
                    request.getPolicyTitle()
            );

            update.setPolicyEffectiveDate(
                    stringToLocalDate(
                        request.getPolicyEffectiveDate()
                    )
            );

            update.setPolicyDescription(
                    request.getPolicyDescription()
            );


            // ---------- Team Announcements ----------

            update.setTeamDate(
                    stringToLocalDate(
                        request.getTeamDate()
                    )
            );

            update.setAchievementTitle(
                    request.getAchievementTitle()
            );

            update.setTeamDescription(
                    request.getTeamDescription()
            );


            // ---------- Save Update ----------

            Update savedUpdate =
                    updateRepository.save(update);


            // ---------- Notify Subscribers ----------

            updateMailService.sendLatestUpdateToAllSubscribers(
                    savedUpdate.getUpdateId()
            );


            return new ApiResponse<>(
                    true,
                    "Update posted successfully and subscribers notified."
            );

        } catch (Exception e) {

            return new ApiResponse<>(
                    false,
                    "Error posting update: " + e.getMessage()
            );
        }
    }


    /**
     * Add a new admin from AdminManageRequest.
     */
    public ApiResponse<Void> addAdmin(
            AdminManageRequest request) {

        try {

            if (adminRepository.existsByAdminEmailId(
                    request.getAdminEmailId())) {

                return new ApiResponse<>(
                        false,
                        "An admin with this email already exists."
                );
            }

            Admin admin = new Admin();

            admin.setAdminEmailId(
                    request.getAdminEmailId()
            );

            admin.setAdminPasswordHash(
                    passwordCryptoUtil.hashPassword(
                            request.getAdminPassword()
                    )
            );

            admin.setCreatedAt(
                    LocalDateTime.now()
            );

            adminRepository.save(admin);

            return new ApiResponse<>(
                    true,
                    "Admin added successfully."
            );

        } catch (Exception e) {

            return new ApiResponse<>(
                    false,
                    "Error adding admin: " + e.getMessage()
            );
        }
    }


    /**
     * Add a new admin from email and password parameters.
     */
    public ApiResponse<Void> addAdmin(
            String adminEmailId,
            String adminPassword) {

        try {

            if (adminRepository.existsByAdminEmailId(
                    adminEmailId)) {

                return new ApiResponse<>(
                        false,
                        "An admin with this email already exists."
                );
            }

            Admin admin = new Admin();

            admin.setAdminEmailId(adminEmailId);

            admin.setAdminPasswordHash(
                    passwordCryptoUtil.hashPassword(
                            adminPassword
                    )
            );

            admin.setCreatedAt(
                    LocalDateTime.now()
            );

            adminRepository.save(admin);

            return new ApiResponse<>(
                    true,
                    "Admin added successfully."
            );

        } catch (Exception e) {

            return new ApiResponse<>(
                    false,
                    "Error adding admin: " + e.getMessage()
            );
        }
    }


    /**
     * Remove an admin by email.
     */
    public ApiResponse<Void> removeAdmin(
            String adminEmailId) {

        try {

            Optional<Admin> adminOpt =
                    adminRepository.findByAdminEmailId(
                            adminEmailId
                    );

            if (adminOpt.isEmpty()) {

                return new ApiResponse<>(
                        false,
                        "No admin found with this email."
                );
            }

            adminRepository.delete(
                    adminOpt.get()
            );

            return new ApiResponse<>(
                    true,
                    "Admin removed successfully."
            );

        } catch (Exception e) {

            return new ApiResponse<>(
                    false,
                    "Error removing admin: " + e.getMessage()
            );
        }
    }
}