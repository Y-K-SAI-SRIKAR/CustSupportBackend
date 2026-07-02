package com.nexvitalssupport.dto.request;

public class ForgotPasswordRequest {

    private String AdminEmailId;

    public ForgotPasswordRequest() {
    }

    public ForgotPasswordRequest(String AdminEmailId) {
        this.AdminEmailId = AdminEmailId;
    }

    public String getAdminEmailId() {
        return AdminEmailId;
    }

    public void setAdminEmailId(String AdminEmailId) {
        this.AdminEmailId = AdminEmailId;
    }
}