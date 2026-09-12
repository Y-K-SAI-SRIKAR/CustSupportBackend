package com.cutomersupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cutomersupport.model.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByOrderByReviewedAtDesc();
}