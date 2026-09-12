package com.cutomersupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Grievances")
public class Grievance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GrievanceId")
    private long GrievanceId;

    @Column(name = "UserEmailId")
    private String EmailId;

    @Column(name = "ClientID")
    private String ClientID;

    @Column(name = "GrievanceCatagory")
    private String GrievanceCatagory;

    @Column(name = "Complaint", columnDefinition = "TEXT")
    private String Complaint;

    @Column(name = "ComplainedAt")
    private LocalDateTime ComplainedAt;

    public Long getGrievanceId() {
        return GrievanceId;
    }

    public String getEmailId() {
        return EmailId;
    }

    public String getClientID() {
        return ClientID;
    }

    public String getGrievanceCatagory() {
        return GrievanceCatagory;
    }

    public String getComplaint() {
        return Complaint;
    }

    public LocalDateTime ComplainedAt() {
        return ComplainedAt;
    }

    public void setGrievanceId(Long GrievanceId) {
        this.GrievanceId = GrievanceId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public void setClientID(String ClientID) {
        this.ClientID = ClientID;
    }

    public void setComplaint(String Complaint) {
        this.Complaint = Complaint;
    }

    public void setGrievanceCatagory(String GrievanceCatagory) {
        this.GrievanceCatagory = GrievanceCatagory;
    }

    public void setComplainedAt(LocalDateTime ComplainedAt) {
        this.ComplainedAt = ComplainedAt;
    }
}