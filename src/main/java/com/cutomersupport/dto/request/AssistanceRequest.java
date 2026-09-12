package com.cutomersupport.dto.request;

public class AssistanceRequest {

    private String EmailId;

    public AssistanceRequest() {
    }

    public AssistanceRequest(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }
}