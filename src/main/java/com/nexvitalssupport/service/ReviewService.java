package com.nexvitalssupport.service;

import com.nexvitalssupport.dto.request.ReviewRequest;
import com.nexvitalssupport.dto.response.ApiResponse;
import com.nexvitalssupport.dto.response.ReviewCarouselResponse;
import com.nexvitalssupport.mail.MailDispatcher;
import com.nexvitalssupport.model.Review;
import com.nexvitalssupport.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MailDispatcher mailDispatcher;

	/**
	 * Get latest N reviews for carousel display
	 */
	public List<ReviewCarouselResponse> getLatestReviews(int limit) {
		try {
			Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "reviewedAt"));
			List<Review> reviews = reviewRepository.findAll(pageable).getContent();

			return reviews.stream()
					.map(this::mapToCarouselResponse)
					.filter(response -> response != null) // Filter out failed mappings
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.err.println("❌ Error fetching latest reviews: " + e.getMessage());
			e.printStackTrace();
			return List.of();
		}
	}

	/**
	 * Submit a review
	 */
	public ApiResponse<Void> submitReview(ReviewRequest request) {
		try {
			Review review = new Review();
			review.setReviewerName(request.getName());
			review.setReviewerEmailId(request.getEmailId());
			review.setNexVitalsDeviceId(request.getNexVitalsDeviceId());
			review.setReviewerCatagory(request.getReviewerCatagory());
			review.setReviewAspect(request.getAspectOfReview());
			review.setReviewContent(request.getReviewText());
			review.setReviewedAt(LocalDateTime.now());

			reviewRepository.save(review);

			mailDispatcher.sendReviewAckMail(request.getEmailId(), request.getName());

			return new ApiResponse<>(true, "Thanks for your review! We've sent you a confirmation mail.");
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error submitting review: " + e.getMessage());
		}
	}

	/**
	 * Map Review entity to CarouselResponse with trimmed text
	 */
	private ReviewCarouselResponse mapToCarouselResponse(Review review) {
		try {
			ReviewCarouselResponse response = new ReviewCarouselResponse();
			response.setReviewId(review.getReviewerId());
			response.setReviewerName(review.getReviewerName() != null ? review.getReviewerName() : "Anonymous");
			response.setReviewerEmailId(review.getReviewerEmailID());
			response.setReviewerCategory(review.getReviewerCatagory());
			
			response.setAspectOfReview(review.getReviewAspect());
			
			// Trim review text to 3 sentences
			String reviewContent = review.getReviewContent() != null ? review.getReviewContent() : "";
			String trimmedText = trimToThreeSentences(reviewContent);
			response.setReviewText(trimmedText);
			
			response.setReviewedAt(review.getReviewedAt());
			return response;
		} catch (Exception e) {
			System.err.println("❌ Error mapping review to carousel response: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Trim text to 3 sentences (ending with fullstop)
	 */
	private String trimToThreeSentences(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}

		// Split by fullstop, exclamation, or question mark
		String[] sentences = text.split("[.!?]+");

		// Take first 3 sentences
		StringBuilder result = new StringBuilder();
		int sentenceCount = 0;

		for (String sentence : sentences) {
			if (sentenceCount >= 3) break;

			String trimmed = sentence.trim();
			if (!trimmed.isEmpty()) {
				if (result.length() > 0) {
					result.append(". ");
				}
				result.append(trimmed);
				sentenceCount++;
			}
		}

		// Add fullstop at the end if not already there
		String finalText = result.toString().trim();
		if (!finalText.isEmpty() && !finalText.endsWith(".") && !finalText.endsWith("!") && !finalText.endsWith("?")) {
			finalText += ".";
		}

		return finalText;
	}
}