package com.cutomersupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewerId")
    private long reviewerId;

    @Column(name = "ReviewerName")
    private String reviewerName;

    @Column(name = "ReviewerEmailId")
    private String reviewerEmailId;

    @Column(name = "ClientID")
    private String clientID;

    @Column(name = "ReviewerCatagory")
    private String reviewerCatagory;

    @Column(name = "ReviewAspect")
    private String aspectOfReview;

    @Column(name = "ReviewContent", columnDefinition = "TEXT")
    private String reviewContent;

    @Column(name = "ReviewedAt")
    private LocalDateTime reviewedAt;

    public Long getReviewerId() {
        return reviewerId;
    }

    public String getReviewerEmailID() {
        return reviewerEmailId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewerCatagory() {
        return reviewerCatagory;
    }

    public String getReviewAspect() {
        return aspectOfReview;
    }

    public String getClientID() {
        return clientID;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public void setReviewerEmailId(String reviewerEmailId) {
        this.reviewerEmailId = reviewerEmailId;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setReviewerCatagory(String reviewerCatagory) {
        this.reviewerCatagory = reviewerCatagory;
    }

    public void setReviewAspect(String aspectOfReview) {
        this.aspectOfReview = aspectOfReview;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public void setReviewedAt(LocalDateTime reviewedAt) {
        this.reviewedAt = reviewedAt;
    }
}