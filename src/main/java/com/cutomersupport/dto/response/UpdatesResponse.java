package com.cutomersupport.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UpdatesResponse {

    private long UpdateId;
    private String Category;
    private String PostedBy;
    private LocalDateTime PostedAt;

    // ---------- product-updates ----------
    private String UpdateTitle;
    private LocalDate DateOfRelease;
    private String VersionNumber;
    private String WhatChanged;
    private String WhoItAffects;

    // ---------- workflow-updates ----------
    private String WorkflowUpdate;
    private LocalDate EffectiveFrom;
    private String UpdateDescription;
    private LocalDate ImplementationDate;

    // ---------- maintenance-notices ----------
    private String NoticeTitle;
    private LocalDateTime StartDateTime;
    private LocalDateTime EndDateTime;
    private String Details;

    // ---------- feature-releases ----------
    private String FeatureTitle;
    private LocalDate FeatureReleaseDate;
    private String FeatureDescription;

    // ---------- policy-updates ----------
    private String PolicyTitle;
    private LocalDate PolicyEffectiveDate;
    private String PolicyDescription;

    // ---------- team-announcements ----------
    private LocalDate TeamDate;
    private String AchievementTitle;
    private String TeamDescription;


    public UpdatesResponse() {
    }


    // ---------- Core fields ----------

    public long getUpdateId() {
        return UpdateId;
    }

    public void setUpdateId(long UpdateId) {
        this.UpdateId = UpdateId;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPostedBy() {
        return PostedBy;
    }

    public void setPostedBy(String PostedBy) {
        this.PostedBy = PostedBy;
    }

    public LocalDateTime getPostedAt() {
        return PostedAt;
    }

    public void setPostedAt(LocalDateTime PostedAt) {
        this.PostedAt = PostedAt;
    }


    // ---------- Product Updates ----------

    public String getUpdateTitle() {
        return UpdateTitle;
    }

    public void setUpdateTitle(String UpdateTitle) {
        this.UpdateTitle = UpdateTitle;
    }

    public LocalDate getDateOfRelease() {
        return DateOfRelease;
    }

    public void setDateOfRelease(LocalDate DateOfRelease) {
        this.DateOfRelease = DateOfRelease;
    }

    public String getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(String VersionNumber) {
        this.VersionNumber = VersionNumber;
    }

    public String getWhatChanged() {
        return WhatChanged;
    }

    public void setWhatChanged(String WhatChanged) {
        this.WhatChanged = WhatChanged;
    }

    public String getWhoItAffects() {
        return WhoItAffects;
    }

    public void setWhoItAffects(String WhoItAffects) {
        this.WhoItAffects = WhoItAffects;
    }


    // ---------- Workflow Updates ----------

    public String getWorkflowUpdate() {
        return WorkflowUpdate;
    }

    public void setWorkflowUpdate(String WorkflowUpdate) {
        this.WorkflowUpdate = WorkflowUpdate;
    }

    public LocalDate getEffectiveFrom() {
        return EffectiveFrom;
    }

    public void setEffectiveFrom(LocalDate EffectiveFrom) {
        this.EffectiveFrom = EffectiveFrom;
    }

    public String getUpdateDescription() {
        return UpdateDescription;
    }

    public void setUpdateDescription(String UpdateDescription) {
        this.UpdateDescription = UpdateDescription;
    }

    public LocalDate getImplementationDate() {
        return ImplementationDate;
    }

    public void setImplementationDate(LocalDate ImplementationDate) {
        this.ImplementationDate = ImplementationDate;
    }


    // ---------- Maintenance Notices ----------

    public String getNoticeTitle() {
        return NoticeTitle;
    }

    public void setNoticeTitle(String NoticeTitle) {
        this.NoticeTitle = NoticeTitle;
    }

    public LocalDateTime getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(LocalDateTime StartDateTime) {
        this.StartDateTime = StartDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return EndDateTime;
    }

    public void setEndDateTime(LocalDateTime EndDateTime) {
        this.EndDateTime = EndDateTime;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }


    // ---------- Feature Releases ----------

    public String getFeatureTitle() {
        return FeatureTitle;
    }

    public void setFeatureTitle(String FeatureTitle) {
        this.FeatureTitle = FeatureTitle;
    }

    public LocalDate getFeatureReleaseDate() {
        return FeatureReleaseDate;
    }

    public void setFeatureReleaseDate(LocalDate FeatureReleaseDate) {
        this.FeatureReleaseDate = FeatureReleaseDate;
    }

    public String getFeatureDescription() {
        return FeatureDescription;
    }

    public void setFeatureDescription(String FeatureDescription) {
        this.FeatureDescription = FeatureDescription;
    }


    // ---------- Policy Updates ----------

    public String getPolicyTitle() {
        return PolicyTitle;
    }

    public void setPolicyTitle(String PolicyTitle) {
        this.PolicyTitle = PolicyTitle;
    }

    public LocalDate getPolicyEffectiveDate() {
        return PolicyEffectiveDate;
    }

    public void setPolicyEffectiveDate(LocalDate PolicyEffectiveDate) {
        this.PolicyEffectiveDate = PolicyEffectiveDate;
    }

    public String getPolicyDescription() {
        return PolicyDescription;
    }

    public void setPolicyDescription(String PolicyDescription) {
        this.PolicyDescription = PolicyDescription;
    }


    // ---------- Team Announcements ----------

    public LocalDate getTeamDate() {
        return TeamDate;
    }

    public void setTeamDate(LocalDate TeamDate) {
        this.TeamDate = TeamDate;
    }

    public String getAchievementTitle() {
        return AchievementTitle;
    }

    public void setAchievementTitle(String AchievementTitle) {
        this.AchievementTitle = AchievementTitle;
    }

    public String getTeamDescription() {
        return TeamDescription;
    }

    public void setTeamDescription(String TeamDescription) {
        this.TeamDescription = TeamDescription;
    }
}