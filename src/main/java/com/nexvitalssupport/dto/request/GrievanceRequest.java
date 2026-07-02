package com.nexvitalssupport.dto.request;

public class GrievanceRequest {

    private String EmailId;
    private String NexVitalsDeviceId;
    private String GrievanceCatagory;
    private String Complaint;

    public GrievanceRequest() {
    }

    public GrievanceRequest(String EmailId, String NexVitalsDeviceId, 
                           String GrievanceCatagory, String Complaint) {
        this.EmailId = EmailId;
        this.NexVitalsDeviceId = NexVitalsDeviceId;
        this.GrievanceCatagory = GrievanceCatagory;
        this.Complaint = Complaint;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getNexVitalsDeviceId() {
        return NexVitalsDeviceId;
    }

    public void setNexVitalsDeviceId(String NexVitalsDeviceId) {
        this.NexVitalsDeviceId = NexVitalsDeviceId;
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