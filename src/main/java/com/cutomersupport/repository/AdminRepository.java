package com.cutomersupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cutomersupport.model.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByAdminEmailId(String adminEmailId);

    boolean existsByAdminEmailId(String adminEmailId);
}