package com.cutomersupport.dto.request;

public class SuggestionRequest {

    private String Name;
    private String EmailId;
    private String Suggestion;

    public SuggestionRequest() {
    }

    public SuggestionRequest(String Name, String EmailId, String Suggestion) {
        this.Name = Name;
        this.EmailId = EmailId;
        this.Suggestion = Suggestion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getSuggestion() {
        return Suggestion;
    }

    public void setSuggestion(String Suggestion) {
        this.Suggestion = Suggestion;
    }
}