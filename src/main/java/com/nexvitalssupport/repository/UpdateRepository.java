package com.nexvitalssupport.repository;

import com.nexvitalssupport.model.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UpdateRepository extends JpaRepository<Update, Long> {
    
    // Used by UpdateMailService: Gets only the single newest update
    Update findFirstByOrderByPostedAtDesc();
    
    // NEW - Used by UpdatesService: Gets ALL updates, sorted newest to oldest
    List<Update> findAllByOrderByPostedAtDesc();
    
    // Used to fetch updates for specific categories
    List<Update> findByCategory(String category);
}