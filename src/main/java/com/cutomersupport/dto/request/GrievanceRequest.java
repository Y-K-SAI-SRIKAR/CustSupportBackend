package com.cutomersupport.dto.request;

public class GrievanceRequest {

    private String EmailId;

    private String ClientID;

    private String GrievanceCatagory;

    private String Complaint;

    public GrievanceRequest() {

    }

    public GrievanceRequest(String EmailId, String ClientID,
                            String GrievanceCatagory, String Complaint) {

        this.EmailId = EmailId;
        this.ClientID = ClientID;
        this.GrievanceCatagory = GrievanceCatagory;
        this.Complaint = Complaint;
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

    public String getGrievanceCatagory() {
        return GrievanceCatagory;
    }

    public void setGrievanceCatagory(String GrievanceCatagory) {
        this.GrievanceCatagory = GrievanceCatagory;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String Complaint) {
        this.Complaint = Complaint;
    }
}