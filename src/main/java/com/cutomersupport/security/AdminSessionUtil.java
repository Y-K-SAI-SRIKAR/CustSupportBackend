package com.cutomersupport.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class AdminSessionUtil {

	private static final String SECRET_KEY = "WavePointSupportAdminSecretKeyForJWTSigning2026ChangeThisInProd";
	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 2; // 2 hours

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	public String generateToken(String adminEmailId) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder()
				.setSubject(adminEmailId)
				.setIssuedAt(now)
				.setExpiration(expiry)
				.signWith(getSigningKey())
				.compact();
	}

	public String extractAdminEmailId(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();

		return claims.getSubject();
	}

	public boolean isTokenValid(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(getSigningKey())
					.build()
					.parseClaimsJws(token)
					.getBody();

			return claims.getExpiration().after(new Date());
		} catch (Exception e) {
			return false;
		}
	}
}