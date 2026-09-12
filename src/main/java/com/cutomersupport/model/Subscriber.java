package com.cutomersupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "Subscribers")
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubscriberId")
	private Long subscriberId;  // ← camelCase field name
	
	@Column(name = "EmailId", nullable = false, unique = true)
	private String emailId;  // ← camelCase
	
	@Column(name = "SubscribedAt", nullable = false)
	private LocalDateTime subscribedAt;  // ← camelCase
	
	// Getters
	public Long getSubscriberId() {
		return subscriberId;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public LocalDateTime getSubscribedAt() {
		return subscribedAt;
	}
	
	// Setters
	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void setSubscribedAt(LocalDateTime subscribedAt) {
		this.subscribedAt = subscribedAt;
	}

	

	public Subscriber orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Subscriber orElseThrow1(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}