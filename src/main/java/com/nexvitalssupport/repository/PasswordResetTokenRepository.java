package com.nexvitalssupport.repository;

import com.nexvitalssupport.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);

    // ✅ This will now work correctly since 'adminEmail' field name matches
    void deleteByAdminEmail(String adminEmail);
    
    // ✅ BONUS: Add these helpful methods
    Optional<PasswordResetToken> findByAdminEmail(String adminEmail);
    
    void deleteByTokenId(Long tokenId);
}