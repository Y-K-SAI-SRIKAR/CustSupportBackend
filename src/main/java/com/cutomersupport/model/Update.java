package com.cutomersupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Updates")
public class Update {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UpdateId")
    private long updateId;

    @Column(name = "Category", nullable = false, length = 50)
    private String category;

    @Column(name = "PostedBy", nullable = false)
    private String postedBy;

    @Column(name = "PostedAt", nullable = false)
    private LocalDateTime postedAt;


    // ---------- product-updates ----------

    @Column(name = "UpdateTitle", length = 500)
    private String updateTitle;

    @Column(name = "DateOfRelease")
    private LocalDate dateOfRelease;

    @Column(name = "VersionNumber", length = 50)
    private String versionNumber;

    @Column(name = "WhatChanged", columnDefinition = "TEXT")
    private String whatChanged;

    @Column(name = "WhoItAffects", columnDefinition = "TEXT")
    private String whoItAffects;


    // ---------- workflow-updates ----------

    @Column(name = "WorkflowUpdate", length = 500)
    private String workflowUpdate;

    @Column(name = "EffectiveFrom")
    private LocalDate effectiveFrom;

    @Column(name = "UpdateDescription", columnDefinition = "TEXT")
    private String updateDescription;

    @Column(name = "ImplementationDate")
    private LocalDate implementationDate;


    // ---------- maintenance-notices ----------

    @Column(name = "NoticeTitle", length = 500)
    private String noticeTitle;

    @Column(name = "StartDateTime")
    private LocalDateTime startDateTime;

    @Column(name = "EndDateTime")
    private LocalDateTime endDateTime;

    @Column(name = "Details", columnDefinition = "TEXT")
    private String details;


    // ---------- feature-releases ----------

    @Column(name = "FeatureTitle", length = 500)
    private String featureTitle;

    @Column(name = "FeatureReleaseDate")
    private LocalDate featureReleaseDate;

    @Column(name = "FeatureDescription", columnDefinition = "TEXT")
    private String featureDescription;


    // ---------- policy-updates ----------

    @Column(name = "PolicyTitle", length = 500)
    private String policyTitle;

    @Column(name = "PolicyEffectiveDate")
    private LocalDate policyEffectiveDate;

    @Column(name = "PolicyDescription", columnDefinition = "TEXT")
    private String policyDescription;


    // ---------- team-announcements ----------

    @Column(name = "TeamDate")
    private LocalDate teamDate;

    @Column(name = "AchievementTitle", length = 500)
    private String achievementTitle;

    @Column(name = "TeamDescription", columnDefinition = "TEXT")
    private String teamDescription;


    // ==================== GETTERS & SETTERS ====================

    public long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(long updateId) {
        this.updateId = updateId;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }


    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }


    // ---------- Product Updates ----------

    public String getUpdateTitle() {
        return updateTitle;
    }

    public void setUpdateTitle(String updateTitle) {
        this.updateTitle = updateTitle;
    }


    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }


    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }


    public String getWhatChanged() {
        return whatChanged;
    }

    public void setWhatChanged(String whatChanged) {
        this.whatChanged = whatChanged;
    }


    public String getWhoItAffects() {
        return whoItAffects;
    }

    public void setWhoItAffects(String whoItAffects) {
        this.whoItAffects = whoItAffects;
    }


    // ---------- Workflow Updates ----------

    public String getWorkflowUpdate() {
        return workflowUpdate;
    }

    public void setWorkflowUpdate(String workflowUpdate) {
        this.workflowUpdate = workflowUpdate;
    }


    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }


    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }


    public LocalDate getImplementationDate() {
        return implementationDate;
    }

    public void setImplementationDate(LocalDate implementationDate) {
        this.implementationDate = implementationDate;
    }


    // ---------- Maintenance Notices ----------

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }


    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }


    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    // ---------- Feature Releases ----------

    public String getFeatureTitle() {
        return featureTitle;
    }

    public void setFeatureTitle(String featureTitle) {
        this.featureTitle = featureTitle;
    }


    public LocalDate getFeatureReleaseDate() {
        return featureReleaseDate;
    }

    public void setFeatureReleaseDate(LocalDate featureReleaseDate) {
        this.featureReleaseDate = featureReleaseDate;
    }


    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }


    // ---------- Policy Updates ----------

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }


    public LocalDate getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    public void setPolicyEffectiveDate(LocalDate policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }


    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }


    // ---------- Team Announcements ----------

    public LocalDate getTeamDate() {
        return teamDate;
    }

    public void setTeamDate(LocalDate teamDate) {
        this.teamDate = teamDate;
    }


    public String getAchievementTitle() {
        return achievementTitle;
    }

    public void setAchievementTitle(String achievementTitle) {
        this.achievementTitle = achievementTitle;
    }


    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }
}