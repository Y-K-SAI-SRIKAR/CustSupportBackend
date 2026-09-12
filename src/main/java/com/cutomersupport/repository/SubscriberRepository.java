package com.cutomersupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cutomersupport.model.Subscriber;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
	
	// ✅ NEW: Get all subscriber emails for bulk notifications
	@Query("SELECT s.emailId FROM Subscriber s")
	List<String> findAllSubscriberEmails();
	
	// Existing methods (keep these)
	boolean existsByEmailId(String emailId);
	Subscriber findByEmailId(String emailId);
	
}