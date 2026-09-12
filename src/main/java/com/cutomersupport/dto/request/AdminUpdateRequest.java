package com.cutomersupport.dto.request;

public class AdminUpdateRequest {

    private String category;

    // Product Updates
    private String updateTitle;
    private String dateOfRelease;
    private String versionNumber;
    private String whatChanged;
    private String whoItAffects;

    // Workflow Updates
    private String workflowUpdate;
    private String effectiveFrom;
    private String updateDescription;
    private String implementationDate;

    // Maintenance Notices
    private String noticeTitle;
    private String startDateTime;
    private String endDateTime;
    private String details;

    // Feature Releases
    private String featureTitle;
    private String featureReleaseDate;
    private String featureDescription;

    // Policy Updates
    private String policyTitle;
    private String policyEffectiveDate;
    private String policyDescription;

    // Team Announcements
    private String teamDate;
    private String achievementTitle;
    private String teamDescription;


    // GETTERS

    public String getCategory() {
        return category;
    }

    public String getUpdateTitle() {
        return updateTitle;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getWhatChanged() {
        return whatChanged;
    }

    public String getWhoItAffects() {
        return whoItAffects;
    }

    public String getWorkflowUpdate() {
        return workflowUpdate;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public String getImplementationDate() {
        return implementationDate;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public String getDetails() {
        return details;
    }

    public String getFeatureTitle() {
        return featureTitle;
    }

    public String getFeatureReleaseDate() {
        return featureReleaseDate;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public String getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public String getTeamDate() {
        return teamDate;
    }

    public String getAchievementTitle() {
        return achievementTitle;
    }

    public String getTeamDescription() {
        return teamDescription;
    }


    // SETTERS

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUpdateTitle(String updateTitle) {
        this.updateTitle = updateTitle;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public void setWhatChanged(String whatChanged) {
        this.whatChanged = whatChanged;
    }

    public void setWhoItAffects(String whoItAffects) {
        this.whoItAffects = whoItAffects;
    }

    public void setWorkflowUpdate(String workflowUpdate) {
        this.workflowUpdate = workflowUpdate;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public void setImplementationDate(String implementationDate) {
        this.implementationDate = implementationDate;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setFeatureTitle(String featureTitle) {
        this.featureTitle = featureTitle;
    }

    public void setFeatureReleaseDate(String featureReleaseDate) {
        this.featureReleaseDate = featureReleaseDate;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public void setPolicyEffectiveDate(String policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public void setTeamDate(String teamDate) {
        this.teamDate = teamDate;
    }

    public void setAchievementTitle(String achievementTitle) {
        this.achievementTitle = achievementTitle;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }
}