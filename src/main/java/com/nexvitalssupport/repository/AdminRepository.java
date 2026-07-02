package com.nexvitalssupport.repository;

import com.nexvitalssupport.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByAdminEmailId(String adminEmailId);

    boolean existsByAdminEmailId(String adminEmailId);
}