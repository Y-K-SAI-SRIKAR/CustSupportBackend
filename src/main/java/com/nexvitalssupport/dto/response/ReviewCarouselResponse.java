package com.nexvitalssupport.dto.response;

public class ReviewCarouselResponse {

	private Long reviewId;
	private String reviewerName;
	private String reviewerEmailId;
	private String reviewerCategory;
	private String aspectOfReview;
	private String reviewText;
	private java.time.LocalDateTime reviewedAt;

	public ReviewCarouselResponse() {
	}

	public ReviewCarouselResponse(Long reviewId, String reviewerName, String reviewerCategory, 
								 String aspectOfReview, String reviewText, java.time.LocalDateTime reviewedAt) {
		this.reviewId = reviewId;
		this.reviewerName = reviewerName;
		this.reviewerCategory = reviewerCategory;
		this.aspectOfReview = aspectOfReview;
		this.reviewText = reviewText;
		this.reviewedAt = reviewedAt;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getReviewerEmailId() {
		return reviewerEmailId;
	}

	public void setReviewerEmailId(String reviewerEmailId) {
		this.reviewerEmailId = reviewerEmailId;
	}

	public String getReviewerCategory() {
		return reviewerCategory;
	}

	public void setReviewerCategory(String reviewerCategory) {
		this.reviewerCategory = reviewerCategory;
	}

	public String getAspectOfReview() {
		return aspectOfReview;
	}

	public void setAspectOfReview(String aspectOfReview) {
		this.aspectOfReview = aspectOfReview;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public java.time.LocalDateTime getReviewedAt() {
		return reviewedAt;
	}

	public void setReviewedAt(java.time.LocalDateTime reviewedAt) {
		this.reviewedAt = reviewedAt;
	}
}