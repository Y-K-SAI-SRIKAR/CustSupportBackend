package com.cutomersupport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "PasswordResetTokens")
public class PasswordResetToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TokenId")
	private long tokenId;

	@Column(name = "Token", nullable = false, unique = true)
	private String token;

	@Column(name = "AdminEmail", nullable = false)
	private String adminEmail;  // ✅ Changed from 'AdminEmail' to 'adminEmail'

	@Column(name = "ExpiryDate", nullable = false)
	private LocalDateTime expiryDate;  // ✅ Changed from 'ExpiryDate' to 'expiryDate'

	@Column(name = "IsUsed", nullable = false)
	private boolean isUsed = false;  // ✅ Changed from 'IsUsed' to 'isUsed'

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
}