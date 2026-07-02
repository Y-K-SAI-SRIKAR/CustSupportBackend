package com.nexvitalssupport.repository;

import com.nexvitalssupport.model.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

    List<Grievance> findAllByOrderByComplainedAtDesc();
}