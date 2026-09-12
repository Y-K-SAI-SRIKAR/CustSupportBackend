package com.cutomersupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cutomersupport.model.Grievance;

import java.util.List;

public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

    List<Grievance> findAllByOrderByComplainedAtDesc();
}