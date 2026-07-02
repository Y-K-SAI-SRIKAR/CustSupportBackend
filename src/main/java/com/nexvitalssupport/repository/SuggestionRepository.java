package com.nexvitalssupport.repository;

import com.nexvitalssupport.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    List<Suggestion> findAllByOrderBySuggestedAtDesc();
}