package com.cutomersupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cutomersupport.model.PasswordResetToken;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);

    // ✅ This will now work correctly since 'adminEmail' field name matches
    void deleteByAdminEmail(String adminEmail);
    
    // ✅ BONUS: Add these helpful methods
    Optional<PasswordResetToken> findByAdminEmail(String adminEmail);
    
    void deleteByTokenId(Long tokenId);
}