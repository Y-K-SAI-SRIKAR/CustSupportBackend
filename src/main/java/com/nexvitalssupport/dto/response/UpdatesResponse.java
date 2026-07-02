package com.nexvitalssupport.dto.response;

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

    // ---------- workflow-announcements ----------
    private String ProtocolUpdate;
    private LocalDate EffectiveFrom;
    private String UpdateDescription;
    private LocalDate ImplementingDateExpected;

    // ---------- maintenance-notices ----------
    private String NoticeTitle;
    private LocalDateTime StartDateTime;
    private LocalDateTime EndDateTime;
    private String Details;

    // ---------- partnership-network-expansion ----------
    private String PartnerTitle;
    private LocalDate PartnerEffectiveFrom;
    private String PartnerDescription;

    // ---------- policy-compliance ----------
    private String PolicyTitle;
    private LocalDate PolicyEffectiveDate;
    private String PolicyDescription;

    // ---------- internal-team-announcements ----------
    private LocalDate TeamDate;
    private String AchievementTitle;
    private String TeamDescription;

    public UpdatesResponse() {
    }

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

    public String getProtocolUpdate() {
        return ProtocolUpdate;
    }
    public void setProtocolUpdate(String ProtocolUpdate) {
        this.ProtocolUpdate = ProtocolUpdate;
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

    public LocalDate getImplementingDateExpected() {
        return ImplementingDateExpected;
    }
    public void setImplementingDateExpected(LocalDate ImplementingDateExpected) {
        this.ImplementingDateExpected = ImplementingDateExpected;
    }

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

    public String getPartnerTitle() {
        return PartnerTitle;
    }
    public void setPartnerTitle(String PartnerTitle) {
        this.PartnerTitle = PartnerTitle;
    }

    public LocalDate getPartnerEffectiveFrom() {
        return PartnerEffectiveFrom;
    }
    public void setPartnerEffectiveFrom(LocalDate PartnerEffectiveFrom) {
        this.PartnerEffectiveFrom = PartnerEffectiveFrom;
    }

    public String getPartnerDescription() {
        return PartnerDescription;
    }
    public void setPartnerDescription(String PartnerDescription) {
        this.PartnerDescription = PartnerDescription;
    }

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