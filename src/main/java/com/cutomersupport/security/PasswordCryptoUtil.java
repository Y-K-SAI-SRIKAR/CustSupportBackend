package com.cutomersupport.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordCryptoUtil {

	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public String hashPassword(String plainPassword) {
		return encoder.encode(plainPassword);
	}

	public boolean verifyPassword(String plainPassword, String hashedPassword) {
		return encoder.matches(plainPassword, hashedPassword);
	}
}