package com.cutomersupport.dto.response;

public class AdminLoginResponse {

    private String Token;
    private String AdminEmailId;
    private String Message;

    public AdminLoginResponse() {
    }

    public AdminLoginResponse(String Token, String AdminEmailId, String Message) {
        this.Token = Token;
        this.AdminEmailId = AdminEmailId;
        this.Message = Message;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getAdminEmailId() {
        return AdminEmailId;
    }

    public void setAdminEmailId(String AdminEmailId) {
        this.AdminEmailId = AdminEmailId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}