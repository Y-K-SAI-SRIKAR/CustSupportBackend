package com.cutomersupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cutomersupport.model.Suggestion;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    List<Suggestion> findAllByOrderBySuggestedAtDesc();
}