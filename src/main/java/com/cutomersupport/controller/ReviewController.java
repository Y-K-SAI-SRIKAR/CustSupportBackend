package com.cutomersupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cutomersupport.dto.request.ReviewRequest;
import com.cutomersupport.dto.response.ApiResponse;
import com.cutomersupport.dto.response.ReviewCarouselResponse;
import com.cutomersupport.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	/**
	 * Get latest 5 reviews for carousel display
	 * GET /api/review/latest
	 */
	@GetMapping("/latest")
	public ApiResponse<List<ReviewCarouselResponse>> getLatestReviews() {
		try {
			List<ReviewCarouselResponse> reviews = reviewService.getLatestReviews(5);
			return new ApiResponse<>(true, "Latest reviews fetched successfully.", reviews);
		} catch (Exception e) {
			return new ApiResponse<>(false, "Error fetching reviews: " + e.getMessage());
		}
	}

	/**
	 * Submit a review
	 * POST /api/review/submit
	 */
	@PostMapping("/submit")
	public ApiResponse<Void> submitReview(@RequestBody ReviewRequest request) {
		return reviewService.submitReview(request);
	}
}