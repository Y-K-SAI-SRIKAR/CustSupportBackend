package com.cutomersupport.dto.request;

public class ReviewRequest {

    private String Name;

    private String EmailId;

    private String ClientID;

    private String ReviewerCatagory;

    private String AspectOfReview;

    private String ReviewText;

    public ReviewRequest() {

    }

    public ReviewRequest(String Name, String EmailId, String ClientID,
                         String ReviewerCatagory, String AspectOfReview, String ReviewText) {

        this.Name = Name;
        this.EmailId = EmailId;
        this.ClientID = ClientID;
        this.ReviewerCatagory = ReviewerCatagory;
        this.AspectOfReview = AspectOfReview;
        this.ReviewText = ReviewText;
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

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    public String getReviewerCatagory() {
        return ReviewerCatagory;
    }

    public void setReviewerCatagory(String ReviewerCatagory) {
        this.ReviewerCatagory = ReviewerCatagory;
    }

    public String getAspectOfReview() {
        return AspectOfReview;
    }

    public void setAspectOfReview(String AspectOfReview) {
        this.AspectOfReview = AspectOfReview;
    }

    public String getReviewText() {
        return ReviewText;
    }

    public void setReviewText(String ReviewText) {
        this.ReviewText = ReviewText;
    }
}