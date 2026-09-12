package com.cutomersupport.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminManageRequest {

    @JsonProperty("AdminEmailId")
    private String AdminEmailId;
    
    @JsonProperty("AdminPassword")
    private String AdminPassword;

    public AdminManageRequest() {
    }

    public AdminManageRequest(String AdminEmailId, String AdminPassword) {
        this.AdminEmailId = AdminEmailId;
        this.AdminPassword = AdminPassword;
    }

    public String getAdminEmailId() {
        return AdminEmailId;
    }

    public void setAdminEmailId(String AdminEmailId) {
        this.AdminEmailId = AdminEmailId;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }
}